package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ExpandArmSubsystem;
/*expanding arm in auto */
public class ExpandArmAutoCommand extends Command {
    private final ExpandArmSubsystem expandArmSubsystem;
    private final double speed;
    private final double time;

    public ExpandArmAutoCommand(ExpandArmSubsystem subsystem, double speed, double time) {
        this.expandArmSubsystem = subsystem;
        this.speed = speed;
        this.time = time;
        addRequirements(expandArmSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        expandArmSubsystem.setExpandSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return Constants.OperatorConstants.timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        expandArmSubsystem.setExpandSpeed(0);
        Constants.OperatorConstants.timer.reset();
    }
}