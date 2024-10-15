package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends Command {

    private MotorSubsystem motorSubsystem;

    public MotorCommand(MotorSubsystem motorSubsytem) {
        this.motorSubsystem = motorSubsystem;
        addRequirements(motorSubsystem);
    }
    
    @Override
    public void execute() {
        motorSubsystem.runMotor();
    }

    @Override
    public void end(boolean interrupted) {
        motorSubsystem.stopMotor();
    }

}
