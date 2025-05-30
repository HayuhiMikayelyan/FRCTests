package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RollerSubsystem;

public class RollerCommand extends Command {
    private final RollerSubsystem rollerSubsystem;
    private final XboxController controller;

    // private int level_1;
    // private int level_2;
    // private int level_3;
    // private int level_4;

    // private int isButtonPressedLevel_1 = 0;
    // private int isButtonPressedLevel_2 = 0;
    // private int isButtonPressedLevel_3 = 0;
    // private int isButtonPressedLevel_4 = 0;

    public RollerCommand(RollerSubsystem subsystem, XboxController controller) {
        this.rollerSubsystem = subsystem;
        this.controller = controller;
        addRequirements(rollerSubsystem);

        // level_1 = rollerSubsystem.level_1;
        // level_2 = rollerSubsystem.level_2;
        // level_3 = rollerSubsystem.level_3;
        // level_4 = rollerSubsystem.level_4;
    }

    @Override
    public void execute() {
        System.out.println("Encoder "+rollerSubsystem.getRotations());
        if (controller.getRightBumperButton()) {
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(1);
            }
        } else if (controller.getRightTriggerAxis() > 0.0) {
            if (rollerSubsystem.isAtHighLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(0.5);
            }
        } else if (controller.getLeftBumperButton()) {
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(-1);
            }
        } else if (controller.getLeftTriggerAxis() > 0.0) {
            if (rollerSubsystem.isAtLowLimit()) {
                rollerSubsystem.setRollerSpeed(0);
            } else {
                rollerSubsystem.setRollerSpeed(-0.4);
            }
        } else {
            rollerSubsystem.setRollerSpeed(0);
        }

    }

    // public void resetButtonsPressed() {
    //     isButtonPressedLevel_1 = 0;
    //     isButtonPressedLevel_2 = 0;
    //     isButtonPressedLevel_3 = 0;
    //     isButtonPressedLevel_4 = 0;
    //     Constants.OperatorConstants.isButtonPressedLevel_0 = false;
    // }

    // public boolean isNoneOfTheButtonsPressed() {
    //     return isButtonPressedLevel_1 == 0 && isButtonPressedLevel_2 == 0 && isButtonPressedLevel_3 == 0
    //             && isButtonPressedLevel_4 == 0 && Constants.OperatorConstants.isButtonPressedLevel_0;
    // }
}

// with four levels
// int pov = controller.getPOV();

// // level 0 check
// if (Constants.OperatorConstants.isButtonPressedLevel_0 &&
// rollerSubsystem.getRotations() > 5) {
// rollerSubsystem.setRollerNegativeSpeed(-0.7);
// } else {
// Constants.OperatorConstants.isButtonPressedLevel_0 = false;
// }

// // level 1 check
// if (isButtonPressedLevel_1 == 1 && rollerSubsystem.getRotations() < level_1)
// {
// rollerSubsystem.setRollerPositiveSpeed(0.7);
// } else if (isButtonPressedLevel_1 == 2 && rollerSubsystem.getRotations() >
// level_1) {
// rollerSubsystem.setRollerNegativeSpeed(-0.7);
// } else {
// isButtonPressedLevel_1 = 0;
// }

// // level 2 check
// if (isButtonPressedLevel_2 == 1 && rollerSubsystem.getRotations() < level_2)
// {
// rollerSubsystem.setRollerPositiveSpeed(0.7);
// } else if (isButtonPressedLevel_2 == 2 && rollerSubsystem.getRotations() >
// level_2) {
// rollerSubsystem.setRollerNegativeSpeed(-0.7);
// } else {
// isButtonPressedLevel_2 = 0;
// }

// // level 3 check
// if (isButtonPressedLevel_3 == 1 && rollerSubsystem.getRotations() < level_3)
// {
// rollerSubsystem.setRollerPositiveSpeed(0.7);
// } else if (isButtonPressedLevel_3 == 2 && rollerSubsystem.getRotations() >
// level_3) {
// rollerSubsystem.setRollerNegativeSpeed(-0.7);
// } else {
// isButtonPressedLevel_3 = 0;
// }

// // level 4 check
// if (isButtonPressedLevel_4 == 1 && rollerSubsystem.getRotations() < level_4)
// {
// rollerSubsystem.setRollerPositiveSpeed(0.7);
// } else if (isButtonPressedLevel_4 == 2 && rollerSubsystem.getRotations() >
// level_4) { ////////////////// ?????????????????
// rollerSubsystem.setRollerNegativeSpeed(-0.7);
// } else {
// isButtonPressedLevel_4 = 0;
// }

// if (pov == 0) {
// // level 1
// resetButtonsPressed(); // ?
// if (rollerSubsystem.getRotations() < level_1) {
// isButtonPressedLevel_1 = 1;
// } else if (rollerSubsystem.getRotations() >= level_1) {
// isButtonPressedLevel_1 = 2;
// }

// }

// else if (pov == 90) {
// // level 2
// resetButtonsPressed(); // ?
// if (rollerSubsystem.getRotations() < level_2) {
// isButtonPressedLevel_2 = 1;
// } else if (rollerSubsystem.getRotations() > level_2) {
// isButtonPressedLevel_2 = 2;
// }
// // isButtonPressedLevel_1 = 0;
// }

// else if (pov == 180) {
// // level 3
// resetButtonsPressed(); // ?
// if (rollerSubsystem.getRotations() < level_3) {
// isButtonPressedLevel_3 = 1;
// } else if (rollerSubsystem.getRotations() > level_3) {
// isButtonPressedLevel_3 = 2;
// }
// // isButtonPressedLevel_1 = 0;
// }

// else if (pov == 270) {
// // level 4
// resetButtonsPressed(); // ?
// if (rollerSubsystem.getRotations() < level_4) {
// isButtonPressedLevel_4 = 1;
// } else if (rollerSubsystem.getRotations() > level_4) {
// isButtonPressedLevel_4 = 2;
// }
// // isButtonPressedLevel_1 = 0;
// }

// else if (controller.getBackButton()) {
// // level 0
// resetButtonsPressed();
// if (rollerSubsystem.getRotations() > 0) {
// Constants.OperatorConstants.isButtonPressedLevel_0 = true;
// Constants.OperatorConstants.timer.start();
// }
// System.out.println("start pressed");

// }

// else if (controller.getRightBumperButton()) {
// resetButtonsPressed();
// rollerSubsystem.moveToPosition(rollerSubsystem.getRotations() + 10, true); //
// quick move up
// }

// else if (controller.getLeftBumperButton()) {
// resetButtonsPressed();
// rollerSubsystem.moveToPosition(rollerSubsystem.getRotations() - 10, false);
// // quick move down
// }

// else {
// if (isNoneOfTheButtonsPressed()) {
// rollerSubsystem.setRollerSpeed(0);
// }
// }