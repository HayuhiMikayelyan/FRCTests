package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RollerSubsystem;  
import frc.robot.commands.RollerCommand;

public class RollerCommandAuto extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final double speed;
    private final int level;

    
    public RollerCommandAuto(RollerSubsystem subsystem,  double speed,int level) {
         this.rollerSubsystem = subsystem;
         this.speed = speed;
         this.level = level;
         addRequirements(rollerSubsystem);
    }

    @Override
    public void initialize() {
        // Constants.OperatorConstants.timer.reset();
        // Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        System.out.println("Encoder:    "+rollerSubsystem.getRotations());
        if (rollerSubsystem.getRotations() < level) {
            rollerSubsystem.moveToPosition(rollerSubsystem.getRotations() + 10,true); // quick move up
        }
    }

    @Override
    public boolean isFinished() {
        return rollerSubsystem.getRotations()>=rollerSubsystem.level_1;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("stop");
        rollerSubsystem.stop();
    }
}   