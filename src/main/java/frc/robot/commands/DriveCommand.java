package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    CommandXboxController controller;
    private DriveSubsystem drive;

    public DriveCommand(CommandXboxController controller, DriveSubsystem drive) {
        this.controller = controller;
        this.drive = drive;

        addRequirements(drive);
    }
    
    // Reset Encoders to 0 rotations
    @Override
    public void initialize() {
        drive.resetEncoders();
    }
    
    // Executes the command to drive
    @Override
    public void execute() {
        drive.drive(controller.getLeftY() * Constants.SPEED_CAP, controller.getRightX() * Constants.SPEED_CAP);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
