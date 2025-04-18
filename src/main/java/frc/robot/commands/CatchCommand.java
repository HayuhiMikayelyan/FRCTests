package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CatchSubsystem;
/*catch command */
public class CatchCommand extends Command {
    private final CatchSubsystem catchSubsystem;
    private final XboxController controller;

    public CatchCommand(CatchSubsystem subsystem, XboxController controller) {
        this.catchSubsystem = subsystem;
        this.controller = controller;
        addRequirements(catchSubsystem);
    }

    @Override
    public void execute() {
        if (controller.getXButton()) {
            System.out.println("X pressed");
            // if (catchSubsystem.isAtOpenLimit()) {
            //     catchSubsystem.setCatchSpeed(0);
            // } else {
                if (catchSubsystem.isAtOpenLimit()) {
                    catchSubsystem.setCatchSpeed(0);
                } else {
                    catchSubsystem.setCatchSpeed(1);
                }
            // }
        } else if (controller.getBButton()) {
            System.out.println("B pressed");
            catchSubsystem.setCatchSpeed(-1);

            
        } else {
            catchSubsystem.setCatchSpeed(0);
        }
    }
}
