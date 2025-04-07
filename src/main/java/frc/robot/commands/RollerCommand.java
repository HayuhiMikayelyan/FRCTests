package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommand extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final XboxController controller;
    private double targetRotations = -1;

    private int isRightBumperPressed = 0;
    private int isLeftBumperPressed = 0;

    public RollerCommand(RollerSubsystem subsystem, XboxController controller) {
        this.rollerSubsystem = subsystem;
        this.controller = controller;
        addRequirements(rollerSubsystem);
        // rollerSubsystem.resetEncoder();
    }

    @Override
    public void execute() {
        System.out.println("Encoder valueeee   " + rollerSubsystem.getRotations());
        if (isRightBumperPressed == 1 && rollerSubsystem.getRotations() < 20) {
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(0.7);
            }
        } else if (isRightBumperPressed == 2 && rollerSubsystem.getRotations() > 20) {
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(-0.7);
            }
        } else {
            isRightBumperPressed = 0;
        }

        if (isLeftBumperPressed == 1 && rollerSubsystem.getRotations() < 60) {
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(0.7);
            }
        } else {
            isLeftBumperPressed = 0;
        }

        if (controller.getRightBumperButton()) {
            if (rollerSubsystem.getRotations() > 0 && rollerSubsystem.getRotations() < 20) {
                isRightBumperPressed = 1;
            } else if (rollerSubsystem.getRotations() > 20) {
                isRightBumperPressed = 2;
            }

        } else if (controller.getLeftTriggerAxis() > 0.0) {
            isLeftBumperPressed = 0;
            isRightBumperPressed = 0;
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(0.7);
            }
        } else if (controller.getLeftBumperButton()) {
            isLeftBumperPressed = 1;
            isRightBumperPressed = 0;
        } else if (controller.getRightTriggerAxis() > 0.0) {
            isLeftBumperPressed = 0;
            isRightBumperPressed = 0;
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(-0.7);
            }
        } else {
            if (isLeftBumperPressed == 0 && isRightBumperPressed == 0) {
                rollerSubsystem.setRollerSpeed(0);
            }
        }

    }
}

// if (controller.getRightBumperButton()) {

// if (rollerSubsystem.isAtHighLimit()) {
// rollerSubsystem.setRollerSpeed(0);
// } else {
// rollerSubsystem.setRollerSpeed(1);
// }
// } else if (controller.getRightTriggerAxis() > 0.0) {
// if (rollerSubsystem.isAtHighLimit()) {
// rollerSubsystem.setRollerSpeed(0);
// } else {
// rollerSubsystem.setRollerSpeed(0.7);
// }
// } else if (controller.getLeftBumperButton()) {
// if (rollerSubsystem.isAtLowLimit()) {
// rollerSubsystem.setRollerSpeed(0);
// } else {
// rollerSubsystem.setRollerSpeed(-1);
// }
// } else if (controller.getLeftTriggerAxis() > 0.0) {
// if (rollerSubsystem.isAtLowLimit()) {
// rollerSubsystem.setRollerSpeed(0);
// } else {
// rollerSubsystem.setRollerSpeed(-0.7);
// }
// } else {
// rollerSubsystem.setRollerSpeed(0);
// }