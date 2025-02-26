package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.controller.PIDController;

public class TurnPIDCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final PIDController pidController;
    private final double targetAngle;

    public TurnPIDCommand(DriveSubsystem driveSubsystem, double targetAngle) {
        this.driveSubsystem = driveSubsystem;
        this.targetAngle = normalizeAngle(targetAngle);
        pidController = new PIDController(0.03, 0, 0.002); // Adjusted PID values
        pidController.setTolerance(2.0); // Allowable error margin

        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        driveSubsystem.resetGyro(); // Reset gyro at start
        pidController.setSetpoint(targetAngle);
    }

    @Override
    public void execute() {
    double currentAngle = driveSubsystem.getGyroAngle();
    double speed = pidController.calculate(currentAngle);
    speed = Math.max(-0.5, Math.min(0.5, speed)); // Limit speed to -0.5 to 0.5

    System.out.println("CURRENT ANGLE: " + currentAngle + " | Target: " + targetAngle);
    
    // driveSubsystem.moveForward(speed, -speed); // Rotate the robot
    }


    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
    }

    private double normalizeAngle(double angle) {
        return ((angle % 360) + 360) % 360; // Ensures angle is always within 0-359
    }
}
