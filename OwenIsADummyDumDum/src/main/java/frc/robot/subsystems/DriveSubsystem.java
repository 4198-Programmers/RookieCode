package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class DriveSubsystem {
    
    private SparkMax motorOne;
    private SparkMax motorTwo;
    private SparkMax motorThree;
    private SparkMax motorFour;

    public DriveSubsystem() {
        motorOne = new SparkMax(1, MotorType.kBrushless);
        motorTwo = new SparkMax(2, MotorType.kBrushless);
        motorThree = new SparkMax(3, MotorType.kBrushless);
        motorFour = new SparkMax(4, MotorType.kBrushless);
    }

    public void drive(double speed, double rotation) {
        drive.
    }
}
