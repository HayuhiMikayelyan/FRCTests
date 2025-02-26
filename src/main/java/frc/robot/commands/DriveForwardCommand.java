package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class DriveForwardCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final double speed;
    private final double time;
    private final Timer timer = new Timer();

    public DriveForwardCommand(DriveSubsystem driveSubsystem, double speed, double time) {
        this.driveSubsystem = driveSubsystem;
        this.speed = speed;
        this.time = time;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();

        timer.start();
    }

    @Override
    public void execute() {
        // driveSubsystem.moveForward(speed, speed); // Move forward
    }

    @Override
    public boolean isFinished() {
        
        return timer.get() >= time; // Stop after the set time
    }

    @Override
    public void end(boolean interrupted) {
        // driveSubsystem.tankDrive(0, 0); // Stop the robot
    }
}
