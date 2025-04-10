package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveCommand extends Command {
    // Initialize the drive subsystem and distance 
    private DriveSubsystem driveSubsystem;
    private double distance;

    /**
     * Automatically drives the robot for a certain distance
     * @param driveSubsystem Subsystem needed to drive
     * @param distance Distance in inches you want the bot to drive before stopping
     */
    public AutoDriveCommand(DriveSubsystem driveSubsystem, double distance) {
        this.driveSubsystem = driveSubsystem;
        this.distance = distance / Constants.WHEEL_CIRCUMFERENCE; // Convert inches to wheel rotations
        
        addRequirements(driveSubsystem);
    }

    public void execute() {
        if (distance >= driveSubsystem.getAverageDriveDistance()) {
            driveSubsystem.drive(0, 0);
        } else {
            driveSubsystem.drive(Constants.DRIVE_SPEED, 0);
        }

    }

    public void end(boolean interrupted) {
        // Stop the robot
        driveSubsystem.drive(0, 0);
    }
}
