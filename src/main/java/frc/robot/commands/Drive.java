package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.MotorSubystem;

public class Drive extends Command {

    private MotorSubystem motorSubystem;

    private CommandXboxController xboxController;

    public Drive(MotorSubystem motorSubystem, CommandXboxController xboxController) {
        this.motorSubystem = motorSubystem;
        this.xboxController = xboxController;
        addRequirements(motorSubystem);
    }
    
    @Override
    public void execute() {
        motorSubystem.drive(xboxController.getRightX() * Constants.SPEED_CAP, xboxController.getLeftY() * Constants.SPEED_CAP);
    }

}
