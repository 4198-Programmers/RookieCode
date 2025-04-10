package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    // Initialize the motors
    private SparkMax motorOne;
    private SparkMax motorTwo;
    private SparkMax motorThree;
    private SparkMax motorFour;

    // Initialize the encoders
    public RelativeEncoder motorOneEncoder;
    public RelativeEncoder motorTwoEncoder;
    public RelativeEncoder motorThreeEncoder;
    public RelativeEncoder motorFourEncoder;

    // Initialize the differential drive
    DifferentialDrive tankDrive;

    public DriveSubsystem() {
        // Define the motors
        motorOne = new SparkMax(Constants.MOTOR_ONE_ID, MotorType.kBrushless);
        motorTwo = new SparkMax(Constants.MOTOR_TWO_ID, MotorType.kBrushless);
        motorThree = new SparkMax(Constants.MOTOR_THREE_ID, MotorType.kBrushless);
        motorFour = new SparkMax(Constants.MOTOR_FOUR_ID, MotorType.kBrushless);

        // Define the encoders
        motorOneEncoder = motorOne.getEncoder();
        motorTwoEncoder = motorTwo.getEncoder();
        motorThreeEncoder = motorThree.getEncoder();
        motorFourEncoder = motorFour.getEncoder();

        // Define tank drive
        tankDrive = new DifferentialDrive(
            // Link motor one and motor three to the left side of the differential drive
            (double leftMotorSpeed) -> {
                motorOne.set(leftMotorSpeed);
                motorThree.set(leftMotorSpeed);
            }, 
            // Link motor two and motor four to the right side of the differential drive
            (double rightMotorSpeed) -> {
                motorTwo.set(rightMotorSpeed);
                motorFour.set(rightMotorSpeed);
            }
        );
    }

    /**
     * Drive the robot using arcade drive
     * @param xSpeed Drive speed of robot
     * @param zRotation Rotation speed of robot
     */
    public void drive(double xSpeed, double zRotation) {
        tankDrive.arcadeDrive(xSpeed, zRotation);
    }

    /**
     * Gets the average drive distance of the four motors
     * @return Average encoder distance
     */
    public double getAverageDriveDistance() {
        return (motorOneEncoder.getPosition() + motorTwoEncoder.getPosition() + motorThreeEncoder.getPosition() + motorFourEncoder.getPosition()) / 4;
    }
}
