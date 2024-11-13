package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    // Initialize motors
    private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_DRIVE_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_DRIVE_MOTOR_ID, MotorType.kBrushless);

    private CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_DRIVE_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_DRIVE_MOTOR_ID, MotorType.kBrushless);

    // How many times it spun
    private RelativeEncoder frontLeftMotorEncoder = frontLeftMotor.getEncoder();
    private RelativeEncoder backLeftMotorEncoder = backLeftMotor.getEncoder();

    private RelativeEncoder frontRightMotorEncoder = frontRightMotor.getEncoder();
    private RelativeEncoder backRightMotorEncoder = backRightMotor.getEncoder();

    // Groups left and right motors to "leftTankTreadSpeed" and "rightTankTreadSpeed"
    DifferentialDrive tankDrive = new DifferentialDrive(
        (double leftTankTreadSpeed) -> {
            frontLeftMotor.set(leftTankTreadSpeed);
            backLeftMotor.set(leftTankTreadSpeed);
        },
        (double rightTankTreadSpeed) -> {
            frontRightMotor.set(rightTankTreadSpeed);
            backRightMotor.set(rightTankTreadSpeed);
        }
    );

    public void drive(double zRotate, double xAxis) {
        tankDrive.arcadeDrive(xAxis, zRotate);
    }

    // Resets Encoders
    public void resetEncoders() {
        frontLeftMotorEncoder.setPosition(0);
        backLeftMotorEncoder.setPosition(0);
        frontRightMotorEncoder.setPosition(0);
        backRightMotorEncoder.setPosition(0);
    }
    // Gets average amount of motor rotations
    public double getRobotPosition() {
        double positionAverage = ((frontLeftMotorEncoder.getPosition() + frontRightMotorEncoder.getPosition() + backLeftMotorEncoder.getPosition() + backRightMotorEncoder.getPosition()) / (4 * Constants.WHEEL_CIRCUMFERENCE));
        return positionAverage;
    }
}