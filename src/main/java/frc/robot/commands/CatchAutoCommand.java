package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.CatchSubsystem;

public class CatchAutoCommand extends Command{
    private final CatchSubsystem catchSubsystem;
    private final double time;
    private final double speed;
    
    public CatchAutoCommand(CatchSubsystem subsystem, double speed, double time) {
         this.catchSubsystem = subsystem;
         this.time = time;
         this.speed = speed;
         addRequirements(catchSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        catchSubsystem.setCatchSpeed(speed);
    }

    
    @Override
    public boolean isFinished() {
        return Constants.OperatorConstants.timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        catchSubsystem.setCatchSpeed(0);
        Constants.OperatorConstants.timer.reset();
    }
}
