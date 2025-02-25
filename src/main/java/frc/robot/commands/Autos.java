package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Command;

public final class Autos {
    public static Command auto(DriveSubsystem driveSubsystem) {
        return Commands.sequence(
            new DriveForwardCommand(driveSubsystem, 0.5, 1), // Move forward for 2 sec
            new TurnPIDCommand(driveSubsystem, 105)    // Turn 60 degrees using gyro
            // new DriveForwardCommand(driveSubsystem, 3, 0.5) // Move forward again
        );
    }
}
