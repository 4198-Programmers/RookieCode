package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand {
    DriveSubsystem driveSubsystem;
    double speed;

    public DriveCommand(DriveSubsystem driveSubsystem, double speed) {
        this.driveSubsystem = driveSubsystem;
        this.speed = speed;
    }

    public void execute() {
        driveSubsystem.drive(RobotContainer.xboxController.getX(), RobotContainer.xboxController.getY());
    }

    public void end() {
        driveSubsystem.drive(0, 0);
    }
}
