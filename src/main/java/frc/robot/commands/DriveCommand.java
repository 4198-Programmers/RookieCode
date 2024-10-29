package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveCommand extends Command {
    private DriveTrainSubsystem drive;
    CommandXboxController controller;

    public DriveCommand(CommandXboxController controller, DriveTrainSubsystem drive) {
        this.controller = controller;
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.drive(controller.getLeftY(), controller.getRightX());
    }
    
    
}
