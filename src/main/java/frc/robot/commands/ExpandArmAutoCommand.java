package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExpandArmSubsystem;

public class ExpandArmAutoCommand extends Command{
    private final ExpandArmSubsystem expandArmSubsystem;
    private final double time;
    
    public ExpandArmAutoCommand(ExpandArmSubsystem subsystem, double time) {
         this.expandArmSubsystem = subsystem;
         this.time = time;
         addRequirements(expandArmSubsystem);
    }

    @Override
    public void execute() {
        // if (controller.getYButton()){
        //     expandArmSubsystem.setExpandSpeed(0.7);
        // } else if (controller.getAButton()){
        //     expandArmSubsystem.setExpandSpeed(-0.7);
        // } else {
        //     expandArmSubsystem.setExpandSpeed(0);
        // }
    }
}
