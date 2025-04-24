package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubystem;

public class MotorSpeedCommand extends Command{
    
    private MotorSubystem motorSubsystem;

    public MotorSpeedCommand(MotorSubystem motorSubsystem) {
        this.motorSubsystem = motorSubsystem;
        addRequirements(motorSubsystem); 
    }

    @Override
    public void execute() {
        motorSubsystem.motorMove(0.5);
    }

    @Override
    public void end(boolean interrupted) {
        motorSubsystem.motorStop();
    }
}
