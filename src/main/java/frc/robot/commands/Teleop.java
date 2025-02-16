package frc.robot.commands;

import frc.robot.subsystems.ArmUDSubsystem;
import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExpandArmSubsystem;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Teleop {
    public static Command teleop(DriveSubsystem dsubsystem, RollerSubsystem rsubsystem,
     CatchSubsystem catchSubsystem, ExpandArmSubsystem expandArmSubsystem,
     ArmUDSubsystem armUDSubsystem, HangSubsystem hangSubsystem, 
     XboxController driveController,  XboxController armController) {
      return Commands.parallel(
        new DriveCommand(dsubsystem, driveController),
        new RollerCommand(rsubsystem, armController),
        new CatchCommand(catchSubsystem, armController),
        new ExpandArmCommand(expandArmSubsystem, armController),
        new ArmUDCommand(armUDSubsystem, armController),
        new HangCommand(hangSubsystem, driveController)
        
        );
    }
  
    private Teleop() {
      throw new UnsupportedOperationException("This is a utility class!");
    }
  }