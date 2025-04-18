package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangSubsystem;
/*suicide command =) */
public class HangCommand extends Command {
    private final HangSubsystem hangSubsystem;
    private final XboxController controller;

    public HangCommand(HangSubsystem subsystem, XboxController controller) {
        this.hangSubsystem = subsystem;
        this.controller = controller;
        addRequirements(hangSubsystem);
    }

    @Override
    public void execute() {

        if (controller.getRightBumperButton()) {
            hangSubsystem.setHangSpeed(1);
        } else if (controller.getRightTriggerAxis() > 0.0) {
            hangSubsystem.setHangSpeed(0.4);

        } else if (controller.getLeftBumperButton()) {
            hangSubsystem.setHangSpeed(-1);

        } else if (controller.getLeftTriggerAxis() > 0.0) {
            hangSubsystem.setHangSpeed(-0.25);

        } else {
            hangSubsystem.setHangSpeed(0);
        }

        // if (controller.getAButton()){
        // hangSubsystem.setHangSpeed(-1);
        // } else if (controller.getYButton()){
        // hangSubsystem.setHangSpeed(0.8);
        // } else {
        // hangSubsystem.setHangSpeed(0);
        // }
    }
}
