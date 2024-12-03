package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainCommand extends Command {

    CommandXboxController controller;

    private DriveTrainSubsystem driveTrainSubsystem;

    public DriveTrainCommand(DriveTrainSubsystem driveTrainSubsystem, CommandXboxController controller) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.controller = controller;
        addRequirements (driveTrainSubsystem);
    };

    @Override
    public void execute() {
        driveTrainSubsystem.drive(controller.getLeftY(), controller.getRightX());
    }

}
