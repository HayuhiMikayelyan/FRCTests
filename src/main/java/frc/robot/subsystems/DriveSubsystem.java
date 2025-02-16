package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax leftFollower = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax rightLeader = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax rightFollower = new SparkMax(6, MotorType.kBrushed);
    
    private final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);

    private final SparkMaxConfig driveConfig = new SparkMaxConfig();

    private CommandXboxController controller = null;
    
        public DriveSubsystem(CommandXboxController controller) {

            this.controller = controller;
            driveConfig.smartCurrentLimit(60);
            driveConfig.voltageCompensation(12);

            //LeftFollower - 2
            driveConfig.follow(leftLeader);
            leftFollower.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

            //RightFollower - 6
            driveConfig.follow(rightLeader);
            rightFollower.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
            
            //LeftFollower - 2
            driveConfig.disableFollowerMode();
            rightLeader.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
            
            // driveConfig.inverted(true);
            leftLeader.configure(driveConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public Command driveCommand() {
        return runOnce(() -> tankDrive(0,0));
    }

    @Override
    public void periodic() {
        tankDrive(controller.getLeftY(), -controller.getRightY());
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

}