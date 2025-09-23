package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JeremeySubystem extends SubsystemBase{
    
    public JeremeySubystem(){}

    private SparkMax jeremyMax = new SparkMax(0, MotorType.kBrushless);

    public void JeremyPringle(){
        jeremyMax.set(0.5);
    }
}
