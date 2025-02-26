package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommandAuto extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final double time;

    
    public RollerCommandAuto(RollerSubsystem subsystem, double time) {
         this.rollerSubsystem = subsystem;
         this.time = time;
         addRequirements(rollerSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        
        // if (!rollerSubsystem.isAtLimit()) {
            rollerSubsystem.setRollerSpeed(1);
        // }
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