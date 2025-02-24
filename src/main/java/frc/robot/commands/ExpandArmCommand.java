package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExpandArmSubsystem;

public class ExpandArmCommand extends Command{
    private final ExpandArmSubsystem expandArmSubsystem;
    private final XboxController controller;
    
    public ExpandArmCommand(ExpandArmSubsystem subsystem, XboxController controller) {
         this.expandArmSubsystem = subsystem;
         this.controller = controller;
         addRequirements(expandArmSubsystem);
    }

    @Override
    public void execute() {
        if (controller.getYButton()){
            expandArmSubsystem.setExpandSpeed(0.7);
        } else if (controller.getAButton()){
            expandArmSubsystem.setExpandSpeed(-0.7);
        } else {
            expandArmSubsystem.setExpandSpeed(0);
        }
    }
}
