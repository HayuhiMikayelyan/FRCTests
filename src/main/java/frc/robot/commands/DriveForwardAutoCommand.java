package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
/* */
public class DriveForwardAutoCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final double time;
    private final double leftSpeed;
    private final double rightSpeed;

    public DriveForwardAutoCommand(DriveSubsystem driveSubsystem, double leftSpeed, double rightSpeed, double time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.setMotorSpeedsAuto(leftSpeed,leftSpeed,rightSpeed,rightSpeed);
    }

    @Override
    public boolean isFinished() {
        
        return Constants.OperatorConstants.timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();;
    }
}
