package frc.robot.commands;

import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Teleop {
    public static Command teleop(DriveSubsystem dsubsystem, RollerSubsystem rsubsystem, CatchSubsystem catchSubsystem, XboxController controller) {
      return Commands.parallel(
        new DriveCommand(dsubsystem, controller),
        new RollerCommand(rsubsystem, controller),
        new CatchCommand(catchSubsystem, controller)
        );
    }
  
    private Teleop() {
      throw new UnsupportedOperationException("This is a utility class!");
    }
  }