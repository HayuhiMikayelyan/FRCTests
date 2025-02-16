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
        if (controller.getAButton()){
            rollerSubsystem.setRollerSpeed(-1);
        } else if (controller.getYButton()){
            rollerSubsystem.setRollerSpeed(0.8);
        } else {
            rollerSubsystem.setRollerSpeed(0);
        }
    }
}
