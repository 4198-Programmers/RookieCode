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

    DifferentialDrive tankDrive;

    public DriveSubsystem() {
        motorOne = new SparkMax(Constants.MOTOR_ONE_ID, MotorType.kBrushless);
        motorTwo = new SparkMax(Constants.MOTOR_TWO_ID, MotorType.kBrushless);
        motorThree = new SparkMax(Constants.MOTOR_THREE_ID, MotorType.kBrushless);
        motorFour = new SparkMax(Constants.MOTOR_FOUR_ID, MotorType.kBrushless);

        tankDrive = new DifferentialDrive(
            (double leftMotorSpeed) -> {
                motorOne.set(leftMotorSpeed);
                motorThree.set(leftMotorSpeed);
            }, 
            (double rightMotorSpeed) -> {
                motorTwo.set(rightMotorSpeed);
                motorFour.set(rightMotorSpeed);
            }
        );
    }

    public void drive(double xSpeed, double zRotation) {
        tankDrive.arcadeDrive(xSpeed, zRotation);
    }
}
