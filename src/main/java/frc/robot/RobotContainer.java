
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Teleop;
import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  private final XboxController driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  private final XboxController armController = new XboxController(OperatorConstants.kArmControllerPort);

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final RollerSubsystem rollerSubsystem = new RollerSubsystem();
  private final CatchSubsystem catchSubsystem = new CatchSubsystem();

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
      return Teleop.teleop(driveSubsystem, rollerSubsystem, catchSubsystem, driverController, armController);
   }
}
