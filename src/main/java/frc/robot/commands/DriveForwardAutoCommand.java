package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class DriveForwardAutoCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final double time;
    private final double leftSpeed;
    private final double rightSpeed;
    private final Timer timer = new Timer();

    public DriveForwardAutoCommand(DriveSubsystem driveSubsystem, double leftSpeed, double rightSpeed, double time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.setMotorSpeedsAuto(leftSpeed,leftSpeed,rightSpeed,rightSpeed);
    }

    @Override
    public boolean isFinished() {
        
        return timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();;
    }
}
