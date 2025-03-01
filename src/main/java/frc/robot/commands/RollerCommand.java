package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommand extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final XboxController controller;
    
    public RollerCommand(RollerSubsystem subsystem, XboxController controller) {
         this.rollerSubsystem = subsystem;
         this.controller = controller;
         addRequirements(rollerSubsystem);
    }

    @Override
    public void execute() {

        if (controller.getRightBumperButton()){
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(1);
            }
        } else if (controller.getRightTriggerAxis() > 0.0){
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(0.7);
            }
        } else if (controller.getLeftBumperButton()){
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            }else{
                // rollerSubsystem.setRollerSpeed(-1);
            }
        } else if (controller.getLeftTriggerAxis() > 0.0){
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            }else{
                rollerSubsystem.setRollerSpeed(-0.8);
            }
        } else {
            rollerSubsystem.setRollerSpeed(0);
        }
    }
}   