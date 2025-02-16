
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Teleop;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  

  private final CommandXboxController driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController armController = new CommandXboxController(OperatorConstants.kArmControllerPort);

  private final DriveSubsystem driveSubsystem = new DriveSubsystem(driverController);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

   public Command getAutonomousCommand() {
      return Autos.exampleAuto(new ExampleSubsystem());
   }

   public Command getTeleopCommand() {
      return Teleop.teleop(driveSubsystem, driverController);
   }
}
