package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommandAuto extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final double time;
    private final double speed;

    
    public RollerCommandAuto(RollerSubsystem subsystem,  double speed, double time) {
         this.rollerSubsystem = subsystem;
         this.time = time;
         this.speed = speed;
         addRequirements(rollerSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        
        if (!rollerSubsystem.isAtHighLimit()) {
            rollerSubsystem.setRollerSpeed(speed);
        }else{
            rollerSubsystem.setRollerSpeed(0);
        }
    }

    @Override
    public boolean isFinished() {
        return Constants.OperatorConstants.timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        rollerSubsystem.stop();
    }
}   