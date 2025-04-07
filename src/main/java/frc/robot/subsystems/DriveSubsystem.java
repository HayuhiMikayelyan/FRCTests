package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftFront = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax leftRear = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax rightFront = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax rightRear = new SparkMax(6, MotorType.kBrushed);

    private final SparkMaxConfig driveConfig = new SparkMaxConfig();
    private final AHRS navx = new AHRS(I2C.Port.kMXP);

    public DriveSubsystem() {

        driveConfig.smartCurrentLimit(60);
        driveConfig.voltageCompensation(12);

        leftFront.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftRear.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightRear.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        navx.reset();
    }

    public void setMotorSpeeds(double leftFrontSpeed, double leftRearSpeed, double rightFrontSpeed, double rightRearSpeed) {
        double driveLeft = 2;
        double driveRight = 2;
        leftFront.set(leftFrontSpeed/driveLeft);
        leftRear.set(leftRearSpeed/driveLeft);
        rightFront.set(rightFrontSpeed/(-driveRight));
        rightRear.set(rightRearSpeed/(-driveRight));
        System.out.println("setMotorSpeeds");
    }

    public void setMotorSpeedsAuto(double leftFrontSpeed, double leftRearSpeed, double rightFrontSpeed, double rightRearSpeed) {
        double driveLeft = -4;
        double driveRight = -3.5;
        leftFront.set(leftFrontSpeed/driveLeft);
        leftRear.set(leftRearSpeed/driveLeft);
        rightFront.set(rightFrontSpeed/(-driveRight));
        rightRear.set(rightRearSpeed/(-driveRight));
    }

    public void stop() {
        navx.reset();
        setMotorSpeeds(0, 0, 0, 0);
    }

    public double getGyroAngle() {
        double angle =  navx.getYaw();
        return angle;
    }

    public void resetGyro() {
        navx.reset();
    }
}
