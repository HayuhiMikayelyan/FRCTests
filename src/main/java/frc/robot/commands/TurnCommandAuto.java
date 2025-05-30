package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
/*drift stuff ig */
public class TurnCommandAuto extends Command {
    private final DriveSubsystem driveSubsystem;
    // private final PIDController pidController;
    private final double targetAngle;

    public TurnCommandAuto(DriveSubsystem driveSubsystem, double targetAngle) {
        this.driveSubsystem = driveSubsystem;
        this.targetAngle = targetAngle;
        // pidController = new PIDController(0.03, 0, 0.002); // Adjusted PID values
        // pidController.setTolerance(2.0); // Allowable error margin

        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        driveSubsystem.resetGyro(); // Reset gyro at start
        // pidController.setSetpoint(targetAngle);
    }

    @Override
    public void execute() {
        System.out.println("Angleeeeeeeeeeeee "+driveSubsystem.getGyroAngle());
        if (targetAngle>0) {
            driveSubsystem.setMotorSpeedsAuto(1.2,1.2, -1.2,-1.2);
        }else{
            driveSubsystem.setMotorSpeedsAuto(-1.2,-1.2, 1.2,1.2);
        }
    // double currentAngle = driveSubsystem.getGyroAngle();
    // double speed = pidController.calculate(currentAngle);
    // speed = Math.max(-0.5, Math.min(0.5, speed)); // Limit speed to -0.5 to 0.5
    
    // driveSubsystem.moveForward(speed, -speed); // Rotate the robot
    }


    @Override
    public boolean isFinished() {
        if (targetAngle>0) {
            return driveSubsystem.getGyroAngle() >= targetAngle;
        }
        return driveSubsystem.getGyroAngle() <= targetAngle;

        // return pidController.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
        
    }

    
}
