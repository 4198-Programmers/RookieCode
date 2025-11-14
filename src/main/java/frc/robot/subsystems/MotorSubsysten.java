package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsysten extends SubsystemBase {
    //variables

    private SparkMax tylerisnotprettycool = new SparkMax(14, MotorType.kBrushless);

    //make the motor

    public MotorSubsysten() {

        

    }

    public void runMotor(double speed ) {

        tylerisnotprettycool.set(speed);
    }

}
