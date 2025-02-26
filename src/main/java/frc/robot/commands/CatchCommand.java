package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CatchSubsystem;

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
        if (controller.getBButton()) {
            // if (catchSubsystem.isAtOpenLimit()) {
            //     catchSubsystem.setCatchSpeed(0);
            // } else {
                catchSubsystem.setCatchSpeed(1);
            // }
        } else if (controller.getXButton()) {
            if (catchSubsystem.isAtOpenLimit()) {
                catchSubsystem.setCatchSpeed(0);
            } else {
                catchSubsystem.setCatchSpeed(-1);
            }
        } else {
            catchSubsystem.setCatchSpeed(0);
        }
    }
}
