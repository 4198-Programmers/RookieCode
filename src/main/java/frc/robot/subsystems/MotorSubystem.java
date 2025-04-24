package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubystem extends SubsystemBase{

    private SparkMax jeremysIntakeMotor;

    public MotorSubystem() {
        jeremysIntakeMotor = new SparkMax(9, MotorType.kBrushless);
    }

    public void motorMove(double jeremysMotorSpeed) {
        jeremysIntakeMotor.set(jeremysMotorSpeed);
    }

    public void motorStop() {
        jeremysIntakeMotor.set(0);
    }


    
}
