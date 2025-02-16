package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

 public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final CommandXboxController controller;
    
    public DriveCommand(DriveSubsystem subsystem, CommandXboxController controller) {
         this.driveSubsystem = subsystem;
         this.controller = controller;
         addRequirements(driveSubsystem);
     }
     
     @Override
     public void execute() {
         driveSubsystem.tankDrive(controller.getLeftY(), -controller.getRightY());
     }
 }