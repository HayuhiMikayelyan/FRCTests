package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public final class Teleop {
    public static Command teleop(DriveSubsystem subsystem, CommandXboxController controller) {
      return Commands.sequence(subsystem.driveCommand(), new DriveCommand(subsystem, controller));
    }
  
    private Teleop() {
      throw new UnsupportedOperationException("This is a utility class!");
    }
  }