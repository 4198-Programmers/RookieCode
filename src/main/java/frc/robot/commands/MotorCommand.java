package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorCommand extends Command{
    

    private MotorSubsystem motorSubsystem;
    
    


    public MotorCommand(MotorSubsystem motorSubsystem) {

        this.motorSubsystem = motorSubsystem;
        addRequirements(motorSubsystem);








    }


}
