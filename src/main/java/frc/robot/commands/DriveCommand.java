package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    // Initialize the drive subsystem and controller
    DriveSubsystem driveSubsystem;
    CommandXboxController controller;

    /**
     * DriveCommand constructor
     * @param driveSubsystem Subsystem needed to drive
     * @param controller An Xbox controller to drive the robot
     */
    public DriveCommand(DriveSubsystem driveSubsystem, CommandXboxController controller) {
        this.driveSubsystem = driveSubsystem;
        this.controller = controller;
    }

    // Execute the command to drive every instance
    @Override
    public void execute() {
        driveSubsystem.drive(controller.getLeftY() * Constants.DRIVE_SPEED, controller.getRightX() * Constants.DRIVE_SPEED);
    }
}
