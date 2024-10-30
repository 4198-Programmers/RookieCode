package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    CommandXboxController controller;
    private DriveSubsystem drive;

    public DriveCommand(CommandXboxController controller, DriveSubsystem drive) {
        this.controller = controller;
        this.drive = drive;

        addRequirements(drive);
    }
    
    // Executes the command to drive
    @Override
    public void execute() {
        drive.drive(controller.getLeftY(), controller.getRightX());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
