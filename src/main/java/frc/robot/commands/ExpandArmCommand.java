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
            expandArmSubsystem.setExpandSpeed(1);
            System.out.println("Y pressed");    
        } else if (controller.getAButton()){
            System.out.println("A pressed");
            expandArmSubsystem.setExpandSpeed(-1);
        } else {
            expandArmSubsystem.setExpandSpeed(0);
        }
    }
}
