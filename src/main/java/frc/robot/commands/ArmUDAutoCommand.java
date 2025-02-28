package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmUDSubsystem;

public class ArmUDAutoCommand extends Command{
    private final ArmUDSubsystem armUDSubsystem;
    private final double time;
    
    public ArmUDAutoCommand(ArmUDSubsystem subsystem, double time) {
         this.armUDSubsystem = subsystem;
         this.time = time;
         addRequirements(armUDSubsystem);
    }

    @Override
    public void initialize() {
        Constants.OperatorConstants.timer.reset();
        Constants.OperatorConstants.timer.start();
    }

    @Override
    public void execute() {
        armUDSubsystem.setUDSpeed(1);
    }

    
    @Override
    public boolean isFinished() {
        return Constants.OperatorConstants.timer.get() >= time;
    }

    @Override
    public void end(boolean interrupted) {
        armUDSubsystem.setUDSpeed(0);
        Constants.OperatorConstants.timer.reset();
    }
}
