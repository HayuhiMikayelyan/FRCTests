
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Autos.AutoMode;
import frc.robot.commands.Teleop;
import frc.robot.subsystems.ArmUDSubsystem;
import frc.robot.subsystems.CatchSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExpandArmSubsystem;
import frc.robot.subsystems.HangSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
/*Here we choose Auto path*/
public class RobotContainer {

  private final XboxController driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  private final XboxController armController = new XboxController(OperatorConstants.kArmControllerPort);

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final RollerSubsystem rollerSubsystem = new RollerSubsystem();
  private final CatchSubsystem catchSubsystem = new CatchSubsystem();
  private final ExpandArmSubsystem expandArmSubsystem = new ExpandArmSubsystem();
  private final ArmUDSubsystem armUDSubsystem = new ArmUDSubsystem();
  private final HangSubsystem hangSubsystem = new HangSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }
  /*to be more accurate its here*/
  public Command getAutonomousCommand() {
    System.out.println("Starting Autonomous Mode...");
    return Autos.auto(AutoMode.CENTER, driveSubsystem, rollerSubsystem, expandArmSubsystem, armUDSubsystem,
        catchSubsystem);
  }

  public Command getTeleopCommand() {
    return Teleop.teleop(driveSubsystem, rollerSubsystem,
        catchSubsystem, expandArmSubsystem, armUDSubsystem,
        hangSubsystem, driverController, armController);
  }
}
