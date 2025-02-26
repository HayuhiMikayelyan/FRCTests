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
        // Configure motors
        driveConfig.smartCurrentLimit(60);
        driveConfig.voltageCompensation(12);

        leftFront.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftRear.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightRear.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        // Check if navX is connected
        if (!navx.isConnected()) {
            System.out.println("NAVX NOT CONNECTED!");
        } else {
            System.out.println("NAVX CONNECTED!");
        }
        navx.reset(); // Reset gyro at startup
    }

    // Method to control each motor separately
    public void setMotorSpeeds(double leftFrontSpeed, double leftRearSpeed, double rightFrontSpeed, double rightRearSpeed) {
        int drive = 3;
        leftFront.set(leftFrontSpeed/4);
        leftRear.set(leftRearSpeed/4);
        rightFront.set(rightFrontSpeed/(-drive));
        rightRear.set(rightRearSpeed/(-drive));
    }

    // Stop all motors
    public void stop() {
        setMotorSpeeds(0, 0, 0, 0);
    }

    // Get gyro angle
    public double getGyroAngle() {
        return navx.getYaw(); // Instead of getAngle()
    }

    // Reset gyro
    public void resetGyro() {
        navx.reset();
    }
}
