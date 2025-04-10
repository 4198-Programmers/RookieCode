package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveCommand extends Command {
    // Initialize the drive subsystem and distance 
    private DriveSubsystem driveSubsystem;
    private double distance;
    private double direction;

    /**
     * Automatically drives the robot for a certain distance
     * @param driveSubsystem Subsystem needed to drive
     * @param distance Inches you want to drive forwards before stopping
     */
    public AutoDriveCommand(DriveSubsystem driveSubsystem, double distance) {
        this.driveSubsystem = driveSubsystem;
        this.distance = distance / Constants.WHEEL_CIRCUMFERENCE; // Convert inches to wheel rotations
        this.direction = distance / Math.abs(distance); // -1 if driving backwards, 1 if driving forwards
        
        addRequirements(driveSubsystem);
    }

    public void execute() {
        // If the robot is past the distance, stop; else, drive.
        if (distance >= driveSubsystem.getAverageDriveDistance()) {
            driveSubsystem.drive(0, 0);
        } else {
            driveSubsystem.drive(direction * Constants.DRIVE_SPEED, 0);
        }
    }

    public void end(boolean interrupted) {
        // Stop the robot
        driveSubsystem.drive(0, 0);
    }
}
