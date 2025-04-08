package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
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
        // if (Constants.OperatorConstants.timer.get()<=4 && Constants.OperatorConstants.timer.get()>0) {
        //     expandArmSubsystem.setExpandSpeed(-1);
        // }else{
        //     expandArmSubsystem.setExpandSpeed(0);
        // }
        if (controller.getYButton()){
            Constants.OperatorConstants.timer.reset();
            expandArmSubsystem.setExpandSpeed(1);
            System.out.println("Y pressed");    
        } else if (controller.getAButton()){
            Constants.OperatorConstants.timer.reset();
            System.out.println("A pressed");
            expandArmSubsystem.setExpandSpeed(-1);
        } else {
            expandArmSubsystem.setExpandSpeed(0);
        }
    }
}
