package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmUDSubsystem;
/*Auto ARM up 'n' down */
public class ArmUDAutoCommand extends Command{
    private final ArmUDSubsystem armUDSubsystem;
    private final double time;
    private final double speed;
    
    public ArmUDAutoCommand(ArmUDSubsystem subsystem, double speed, double time) {
         this.armUDSubsystem = subsystem;
         this.speed = speed;
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
        armUDSubsystem.setUDSpeed(speed);
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