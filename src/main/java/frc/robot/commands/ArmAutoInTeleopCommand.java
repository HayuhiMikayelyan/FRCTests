package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmUDSubsystem;
import frc.robot.subsystems.ExpandArmSubsystem;
import frc.robot.subsystems.RollerSubsystem;

public class ArmAutoInTeleopCommand extends Command {
    private final ExpandArmSubsystem expandArmSubsystem;
    private final ArmUDSubsystem armUDSubsystem;
    private final RollerSubsystem rollerSubsystem;
    private final XboxController controller;
    private SequentialCommandGroup autoSequence; // Store the sequence
    private boolean commandStarted = false;

    public ArmAutoInTeleopCommand(
                                  ExpandArmSubsystem expandArmSubsystem, 
                                  ArmUDSubsystem armUDSubsystem, 
                                  RollerSubsystem rollerSubsystem, 
                                  XboxController controller) {
        this.expandArmSubsystem = expandArmSubsystem;
        this.armUDSubsystem = armUDSubsystem;
        this.rollerSubsystem = rollerSubsystem;
        this.controller = controller;
        System.out.println("AUto Command created...................");
        addRequirements(expandArmSubsystem, armUDSubsystem, rollerSubsystem);
    }

    @Override
    public void execute() {
        System.out.println("aaaaaaaaaaaaaa"+commandStarted);
        if (controller.getLeftBumper() && !commandStarted) {
            commandStarted = true;
            System.out.println("MTAAAAAAAAAAAAAAAAAAAAAAA"+commandStarted);

            autoSequence = new SequentialCommandGroup(
                new ExpandArmAutoCommand(expandArmSubsystem, -0.7, 4)
                // new ArmUDAutoCommand(armUDSubsystem, -1, 0.6),
                // new RollerCommandAuto(rollerSubsystem, 0.8, 4)
            );

            autoSequence.schedule(); // Schedule the sequence
        }
    }

    @Override
    public boolean isFinished() {
        return commandStarted && (autoSequence == null || autoSequence.isFinished());
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("ArmAutoInTeleopCommand was interrupted!");
            if (autoSequence != null) {
                autoSequence.cancel(); // Cancel the sequence if needed
            }
        }
        commandStarted = false; // Reset for future activation
    }
}
