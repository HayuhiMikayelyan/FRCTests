package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.controllers.PPLTVController;

public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax leftFollower = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax rightLeader = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax rightFollower = new SparkMax(6, MotorType.kBrushed);
    
    private final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);
    private final SparkMaxConfig driveConfig = new SparkMaxConfig();

    private final RelativeEncoder leftEncoder = leftLeader.getEncoder(); // Keep only left encoder

    private final AHRS gyro = new AHRS(SPI.Port.kMXP);
    private final DifferentialDriveOdometry odometry;
    private RobotConfig config;
    
    // Robot physical parameters
    private final double trackWidth = 0.5; // Distance between left and right wheels (meters)

    public DriveSubsystem() {
        driveConfig.smartCurrentLimit(60);
        driveConfig.voltageCompensation(12);

        driveConfig.follow(leftLeader);
        leftFollower.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        driveConfig.follow(rightLeader);
        rightFollower.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        driveConfig.disableFollowerMode();
        rightLeader.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftLeader.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        resetEncoders();
        gyro.reset();

        odometry = new DifferentialDriveOdometry(
            Rotation2d.fromDegrees(getHeading()), 
            leftEncoder.getPosition(), 
            estimateRightDistance()
        );

        try {
            config = RobotConfig.fromGUISettings();
        
            AutoBuilder.configure(
                this::getPose,
                this::resetPose,
                this::getRobotRelativeSpeeds,
                (speeds, feedforwards) -> driveRobotRelative(speeds),
                new PPLTVController(0.02),
                config,
                () -> {
                    var alliance = DriverStation.getAlliance();
                    return alliance.isPresent() && alliance.get() == DriverStation.Alliance.Red;
                },
                this
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetPose(Pose2d pose) {
        resetEncoders();
        odometry.resetPosition(Rotation2d.fromDegrees(getHeading()), leftEncoder.getPosition(), estimateRightDistance(), pose);
    }

    @Override
    public void periodic() {
        odometry.update(Rotation2d.fromDegrees(getHeading()), leftEncoder.getPosition(), estimateRightDistance());
    }

    public Command driveCommand() {
        return runOnce(() -> tankDrive(0, 0));
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        double delay = 2;
        drive.tankDrive(leftSpeed / (-delay),rightSpeed / (-delay));
    }
    public Pose2d getPose() {
        return odometry.getPoseMeters();
    }

    public void resetOdometry(Pose2d pose) {
        resetEncoders();
        odometry.resetPosition(Rotation2d.fromDegrees(getHeading()), leftEncoder.getPosition(), estimateRightDistance(), pose);
    }

    private void resetEncoders() {
        leftEncoder.setPosition(0);
    }

    private double getHeading() {
        return gyro.getAngle();
    }

    // 🔹 Estimate Right Wheel Distance Using the Gyro
    private double estimateRightDistance() {
        double leftDistance = leftEncoder.getPosition();
        double headingRadians = Math.toRadians(getHeading());

        return leftDistance - (headingRadians * trackWidth);
    }

    public ChassisSpeeds getRobotRelativeSpeeds() {
        double vx = 0.1;
        double vy = -0.1;
        double omega = gyro.getRate();
        return new ChassisSpeeds(vx, vy, omega);
    }

    public void driveRobotRelative(ChassisSpeeds speeds) {
        //speeds.vxMetersPerSecond
        drive.arcadeDrive(0.5, speeds.omegaRadiansPerSecond);
    }
}