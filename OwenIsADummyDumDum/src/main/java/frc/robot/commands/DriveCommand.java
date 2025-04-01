package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    DriveSubsystem driveSubsystem;
    CommandXboxController controller;

    public DriveCommand(DriveSubsystem driveSubsystem, CommandXboxController controller) {
        this.driveSubsystem = driveSubsystem;
        this.controller = controller;
    }

    public void execute() {
        driveSubsystem.drive(controller.getRightY(), controller.getLeftX());
    }

    public void end() {
        driveSubsystem.drive(0, 0);
    }
}
