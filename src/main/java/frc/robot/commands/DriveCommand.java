package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    // Define the drive subsystem and controller
    DriveSubsystem driveSubsystem;
    CommandXboxController controller;

    /**
     * DriveCommand constructor
     * @param driveSubsystem
     * @param controller
     */
    public DriveCommand(DriveSubsystem driveSubsystem, CommandXboxController controller) {
        this.driveSubsystem = driveSubsystem;
        this.controller = controller;
    }

    // Execute the command to drive every instance
    public void execute() {
        driveSubsystem.drive(controller.getRightY(), controller.getLeftX());
    }

    // Stop the robot from moving when the command ends
    public void end() {
        driveSubsystem.drive(0, 0);
    }
}
