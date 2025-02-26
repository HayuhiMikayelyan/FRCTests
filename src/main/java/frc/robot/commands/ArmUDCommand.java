package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmUDSubsystem;

public class ArmUDCommand extends Command{
    private final ArmUDSubsystem armUDSubsystem;
    private final XboxController controller;
    
    public ArmUDCommand(ArmUDSubsystem subsystem, XboxController controller) {
         this.armUDSubsystem = subsystem;
         this.controller = controller;
         addRequirements(armUDSubsystem);
    }

    @Override
    public void execute() {
        int pov = controller.getPOV();
        if (pov==0){
            armUDSubsystem.setUDSpeed(1);
        }else if (pov==180) {
            armUDSubsystem.setUDSpeed(-1);
        } 
        else {
            armUDSubsystem.setUDSpeed(0);
        }
    }
}
