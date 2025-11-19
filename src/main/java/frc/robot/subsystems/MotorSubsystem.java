package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase{

    private SparkMax motorOne = new SparkMax(14, MotorType.kBrushless);



    public MotorSubsystem() {

    
        
    }

    public void runMotor(double speed) {

        motorOne.set(speed);

    }

    //run motor

}
