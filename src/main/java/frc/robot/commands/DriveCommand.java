package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final XboxController controller;
    
    public DriveCommand(DriveSubsystem subsystem, XboxController controller) {
         this.driveSubsystem = subsystem;
         this.controller = controller;
         addRequirements(driveSubsystem);
     }
     
     @Override
     public void execute() {
        // System.out.println("Drive command: "+driveSubsystem.getGyroAngle());

        driveSubsystem.setMotorSpeeds(controller.getLeftY(),controller.getLeftY(), controller.getRightY(),controller.getRightY());
     }
 }