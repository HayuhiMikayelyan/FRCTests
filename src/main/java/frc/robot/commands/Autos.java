package frc.robot.commands;

import frc.robot.subsystems.ArmUDSubsystem;
import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExpandArmSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
    public static Command auto(DriveSubsystem driveSubsystem, RollerSubsystem rollerSubsystem,
     ExpandArmSubsystem expandArmSubsystem, ArmUDSubsystem armUDSubsystem,
     CatchSubsystem catchSubsystem
     ) {
        return Commands.sequence(
            new RollerCommandAuto(rollerSubsystem, 2.7),
            new DriveForwardAutoCommand(driveSubsystem,1,1,2),
            new ExpandArmAutoCommand(expandArmSubsystem, 3.6),
            new ArmUDAutoCommand(armUDSubsystem, 1),
            new CatchAutoCommand(catchSubsystem, 2)
            // new InstantCommand(driveSubsystem::stop, driveSubsystem),
            // new WaitCommand(1),// Move forward for 2 sec
            // new TurnCommandAuto(driveSubsystem, 89),

            // new WaitCommand(2)// Move forward for 2 sec


            // new DriveForwardCommand(driveSubsystem,1,1 ,1), 
            // new WaitCommand(1),// Move forward for 2 sec

            // new TurnPIDCommand(driveSubsystem, 85)    // Turn 60 degrees using gyro
            // // new DriveForwardCommand(driveSubsystem, 3, 0.5) // Move forward again
        );
    }
}
