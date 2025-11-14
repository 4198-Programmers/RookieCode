package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsysten;

public class CommandMotor extends Command{

private MotorSubsysten motorSubsysten;

private double speed;

    public CommandMotor(MotorSubsysten motorSubsysten, double speed) {

        this.motorSubsysten = motorSubsysten;
        this.speed = speed;

        addRequirements(motorSubsysten);

    }
    
    @Override
    public void execute() {
        motorSubsysten.runMotor(speed);
    }
//end motor

    @Override
    public void end(boolean interrupted) {
        motorSubsysten.runMotor(0);

    }

}
