package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax leftFollower = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax rightLeader = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax rightFollower = new SparkMax(6, MotorType.kBrushed);
    
    private final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);
    private final SparkMaxConfig driveConfig = new SparkMaxConfig();

    private final AHRS navx = new AHRS(SPI.Port.kMXP); // NavX Gyro

    
    
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

        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESET NAVX");

        
        if (!navx.isConnected()) {
            System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOT");
        } else {
            System.out.println("YEEEEEEEEEEEEEEEEEEEEEEEEEEEEES");
        }

        navx.reset(); // Reset gyro at startup

    

    // Configure AutoBuilder last
    }


    public Command driveCommand() {
        return runOnce(() -> tankDrive(0,0));
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        double delay = 2;
        drive.tankDrive(leftSpeed/(-delay), rightSpeed/(-delay));
    }

    public void moveForward(double leftSpeed, double rightSpeed) {
        
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive.tankDrive(0, 0);
    }

    public double getGyroAngle() {
        return navx.getAngle(); // Returns the current gyro angle
    }

    public void resetGyro() {
        navx.reset(); // Resets gyro angle to zero
    }
}