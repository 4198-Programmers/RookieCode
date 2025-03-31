package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem {
    
    private SparkMax motorOne;
    private SparkMax motorTwo;
    private SparkMax motorThree;
    private SparkMax motorFour;

    public DriveSubsystem() {
        motorOne = new SparkMax(Constants.MOTOR_ONE_ID, MotorType.kBrushless);
        motorTwo = new SparkMax(Constants.MOTOR_TWO_ID, MotorType.kBrushless);
        motorThree = new SparkMax(Constants.MOTOR_THREE_ID, MotorType.kBrushless);
        motorFour = new SparkMax(Constants.MOTOR_FOUR_ID, MotorType.kBrushless);

        DifferentialDrive tankDrive = new DifferentialDrive(motorOne, motorTwo);
    }

    public void drive(double speed, double rotation) {
        tankDrive.arcadeDrive(speed, rotation);
    }
}
