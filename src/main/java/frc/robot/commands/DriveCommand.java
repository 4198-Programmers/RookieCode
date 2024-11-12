package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.driveTrain;



public class DriveCommand extends Command {
    private CommandXboxController controller;
    private driveTrain drive;

    public DriveCommand(CommandXboxController controller, driveTrain drive) {
        this.controller = controller;
        this.drive = drive;

        addRequirements(drive);
    }

    @Override
    public void execute() { 
        drive.drive(controller.getLeftY(), controller.getRightX());
    }
}
