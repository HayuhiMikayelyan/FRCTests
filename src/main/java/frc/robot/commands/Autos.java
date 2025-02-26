package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
    public static Command auto(DriveSubsystem driveSubsystem) {
        return Commands.sequence(
            new DriveForwardAutoCommand(driveSubsystem,1,1,1), 
            // new InstantCommand(driveSubsystem::stop, driveSubsystem),
            new WaitCommand(1),// Move forward for 2 sec
            new TurnCommandAuto(driveSubsystem, 89),

            new WaitCommand(2)// Move forward for 2 sec


            // new DriveForwardCommand(driveSubsystem,1,1 ,1), 
            // new WaitCommand(1),// Move forward for 2 sec

            // new TurnPIDCommand(driveSubsystem, 85)    // Turn 60 degrees using gyro
            // // new DriveForwardCommand(driveSubsystem, 3, 0.5) // Move forward again
        );
    }
}
