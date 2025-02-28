package frc.robot.commands;

import frc.robot.subsystems.ArmUDSubsystem;
import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExpandArmSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
    public enum AutoMode {
        LEFT,
        CENTER,
        RIGHT
    }

    public static Command auto(AutoMode mode, DriveSubsystem driveSubsystem, RollerSubsystem rollerSubsystem,
            ExpandArmSubsystem expandArmSubsystem, ArmUDSubsystem armUDSubsystem,
            CatchSubsystem catchSubsystem) {
        switch (mode) {
            case LEFT:
                return Commands.sequence(
                        new RollerCommandAuto(rollerSubsystem, 0.8, 4),
                        new WaitCommand(0.5),
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 3.0), // Adjusted for left start
                        new TurnCommandAuto(driveSubsystem, 45), // Turn toward scoring position
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 2.0),
                        new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 4),
                        new ArmUDAutoCommand(armUDSubsystem, 1, 0.6),
                        new RollerCommandAuto(rollerSubsystem, -0.8, 0.2),
                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, 1));

            case RIGHT:
                return Commands.sequence(
                        new RollerCommandAuto(rollerSubsystem, 0.8, 4),
                        new WaitCommand(0.5),
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 3.0), // Adjusted for right start
                        new TurnCommandAuto(driveSubsystem, 45), // Turn toward scoring position
                        new ExpandArmAutoCommand(expandArmSubsystem, 4, 0.7),
                        new ArmUDAutoCommand(armUDSubsystem, 1, 0.6),
                        new RollerCommandAuto(rollerSubsystem, -0.8, 0.2),
                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, 1));

            case CENTER:
            default:
                return Commands.sequence(
                        new RollerCommandAuto(rollerSubsystem, 0.8, 4),
                        new WaitCommand(0.5),
                        // center
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 2.5),
                        new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 4),
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 0.5),
                        new WaitCommand(0.5),
                        new ArmUDAutoCommand(armUDSubsystem, 1, 0.5),
                        new RollerCommandAuto(rollerSubsystem, -0.8, 0.1),
                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, 1)

                // new DriveForwardAutoCommand(driveSubsystem,1,1 ,1),
                // new
                // DriveForwardAutoCommand(driveSubsystem,1,1,(Constants.OperatorConstants.dcFrom1To2/Constants.OperatorConstants.robotSpeed)),
                // new TurnCommandAuto(driveSubsystem, 45),
                // new
                // DriveForwardAutoCommand(driveSubsystem,1,1,(Constants.OperatorConstants.dcFrom2To3/Constants.OperatorConstants.robotSpeed)),

                // new WaitCommand(2),
                );
        }
    }
}
