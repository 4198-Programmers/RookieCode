package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    // Initialize motors
    private CANSparkMax motorFrontLeft = new CANSparkMax(Constants.MOTOR_FRONT_LEFT_ID, MotorType.kBrushless);
    private CANSparkMax motorBackLeft = new CANSparkMax(Constants.MOTOR_BACK_LEFT_ID, MotorType.kBrushless);

    private CANSparkMax motorFrontRight = new CANSparkMax(Constants.MOTOR_FRONT_RIGHT_ID, MotorType.kBrushless);
    private CANSparkMax motorBackRight = new CANSparkMax(Constants.MOTOR_BACK_RIGHT_ID, MotorType.kBrushless);

    // How many times it spun
    private RelativeEncoder motorFrontLeftEncoder = motorFrontLeft.getEncoder();
    private RelativeEncoder motorBackLeftEncoder = motorBackLeft.getEncoder();

    private RelativeEncoder motorFrontRightEncoder = motorFrontRight.getEncoder();
    private RelativeEncoder motorBackRightEncoder = motorBackRight.getEncoder();

    // Groups left and right motors to "leftTankTreadSpeed" and "rightTankTreadSpeed"
    DifferentialDrive tankDrive = new DifferentialDrive(
        (double leftTankTreadSpeed) -> {
            motorFrontLeft.set(leftTankTreadSpeed);
            motorBackLeft.set(leftTankTreadSpeed);
        },
        (double rightTankTreadSpeed) -> {
            motorFrontRight.set(rightTankTreadSpeed);
            motorBackRight.set(rightTankTreadSpeed);
        }
    );

    public void drive(double zRotate, double xAxis) {
        tankDrive.arcadeDrive(xAxis, zRotate);
    }

    // Resets Encoders
    public void resetEncoders() {
        motorFrontLeftEncoder.setPosition(0);
        motorBackLeftEncoder.setPosition(0);
        motorFrontRightEncoder.setPosition(0);
        motorBackRightEncoder.setPosition(0);
    }
    // Gets average amount of motor rotations
    public double getRobotPosition() {
        double positionAverage = ((motorFrontLeftEncoder.getPosition() + motorFrontRightEncoder.getPosition() + motorBackLeftEncoder.getPosition() + motorBackRightEncoder.getPosition()) / (4 * Constants.WHEEL_CIRCUMFERENCE));
        return positionAverage;
    }
}