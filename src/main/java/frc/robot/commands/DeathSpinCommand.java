package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class DeathSpinCommand extends Command {
    CommandXboxController controller;
    private DriveSubsystem drive;

    double rotationSpeed = 1 * Constants.SPEED_CAP;

    public DeathSpinCommand(DriveSubsystem drive) {
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
        drive.drive(rotationSpeed, 0);
    }

    @Override
    public void end(boolean interrupted) {
        drive.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
