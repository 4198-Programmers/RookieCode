package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Jeremy;

public class DriveBaseCommand extends Command{

    private Jeremy jeremy;
    private CommandXboxController commandXboxController;

    public DriveBaseCommand(Jeremy jeremy, CommandXboxController commandXboxController) {
        this.jeremy = jeremy;
        this.commandXboxController = commandXboxController;
        addRequirements(jeremy);
    }
    
    @Override
    public void execute() {
        jeremy.drive(commandXboxController.getLeftY() * Constants.DRIVE_SPEED, commandXboxController.getRightX() * Constants.DRIVE_SPEED);
    }

}
