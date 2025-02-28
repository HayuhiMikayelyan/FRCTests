package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HangSubsystem;

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
        if (controller.getAButton()){
        hangSubsystem.setHangSpeed(-1);
        } else if (controller.getYButton()){
        hangSubsystem.setHangSpeed(1);
        } else {
        hangSubsystem.setHangSpeed(0);
        }
    }
}
