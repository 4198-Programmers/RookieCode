package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubystem extends SubsystemBase{
    
    public MotorSubystem() {}

    public SparkMax jeremy = new SparkMax(0, MotorType.kBrushless);

    public void runMotor(double speed) {
        jeremy.set(speed);
    }

    //run motor
    
}
