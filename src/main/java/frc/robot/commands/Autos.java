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
        RIGHT,
        CENTER_LEV_2
    }

    public static Command auto(AutoMode mode, DriveSubsystem driveSubsystem, RollerSubsystem rollerSubsystem,
            ExpandArmSubsystem expandArmSubsystem, ArmUDSubsystem armUDSubsystem,
            CatchSubsystem catchSubsystem) {
        switch (mode) {
            case LEFT:
                return Commands.sequence(
                        // new CatchAutoCommand(catchSubsystem, -1, 1),
                        // new RollerCommandAuto(rollerSubsystem, 0.8),
                        // new WaitCommand(0.5),
                        // // center
                        // new DriveForwardAutoCommand(driveSubsystem, 1, 1, 4),
                        // new TurnCommandAuto(driveSubsystem, 120),
                        // new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 4),
                        // new DriveForwardAutoCommand(driveSubsystem, 1, 1, 0.8),
                        // new WaitCommand(0.5),
                        // new ArmUDAutoCommand(armUDSubsystem, 1, 0.6),
                        // new RollerCommandAuto(rollerSubsystem, -0.8),
                        // new WaitCommand(1),
                        // new CatchAutoCommand(catchSubsystem, 1, 1));

                        new CatchAutoCommand(catchSubsystem, 1, 1),
                        new RollerCommandAuto(rollerSubsystem, 0.8, rollerSubsystem.level_1),
                        // center
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 1.7),
                        new TurnCommandAuto(driveSubsystem, 120),
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 0.8),
                        new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 0.3),

                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, -1, 1),
                        new DriveForwardAutoCommand(driveSubsystem, -1, -1, 1)
                        );
            case RIGHT:
                return Commands.sequence(
                        new CatchAutoCommand(catchSubsystem, 1, 1),
                        new RollerCommandAuto(rollerSubsystem, 0.8, rollerSubsystem.level_1),
                        // center
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 1.7),
                        new TurnCommandAuto(driveSubsystem, -120),
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 0.8),
                        new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 0.3),

                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, -1, 1),
                        new DriveForwardAutoCommand(driveSubsystem, -1, -1, 1)                        );
            case CENTER_LEV_2:
                return Commands.sequence(
                        new CatchAutoCommand(catchSubsystem, 1, 1),
                        new RollerCommandAuto(rollerSubsystem, 0.8, rollerSubsystem.level_2),
                        // center
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 2.6),
                        // new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 0.4),

                        new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, -1, 1));

            case CENTER:
            default:
                return Commands.sequence(
                        // new ExpandArmAutoCommand(expandArmSubsystem, -0.7, 023),
                        // new WaitCommand(2),

                        new CatchAutoCommand(catchSubsystem, 1, 1),
                        new RollerCommandAuto(rollerSubsystem, 0.8, rollerSubsystem.level_1),
                        // center
                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 2.6),
                        new ExpandArmAutoCommand(expandArmSubsystem, 0.7, 0.3),
                        // new DriveForwardAutoCommand(driveSubsystem, 1, 1, 0.8),
                        // new WaitCommand(0.5),
                        // new ArmUDAutoCommand(armUDSubsystem, 1, 0.6),
                        // new RollerCommandAuto(rollerSubsystem, -0.8, 0.1),
                        // new WaitCommand(1),
                        new CatchAutoCommand(catchSubsystem, -1, 1),
                        new WaitCommand(0.5),
                        new ExpandArmAutoCommand(expandArmSubsystem, -0.7, 0.3),
                        new DriveForwardAutoCommand(driveSubsystem, -1, -1, 1),
                        new TurnCommandAuto(driveSubsystem, 45),

                        new DriveForwardAutoCommand(driveSubsystem, 1, 1, 1)


                );
        }
    }
}