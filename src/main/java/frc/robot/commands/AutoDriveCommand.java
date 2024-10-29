package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Maths;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveCommand extends Command {

    private DriveSubsystem drive;

    

    double distance = 50; // Inches
    double speed = 0.5; // -1.0 <= Speed <= 1.0

    public AutoDriveCommand(DriveSubsystem drive) {
        this.drive = drive;

        addRequirements(drive);
    }


    // Do I need to reset the encoders every time it initializes?

    @Override
    public void execute() {
        // Stop robot if over distance 
        // No worky |
        //          |
        if (DriveSubsystem.getRobotPosition() >= Maths.rotationConversion(distance)) {
            end(true);
        } else {
            drive.drive(0, speed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        drive.drive(0, 0);
    }
}
