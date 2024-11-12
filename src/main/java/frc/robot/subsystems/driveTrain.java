package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {
    CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
    CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
    CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
    CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);

    private RelativeEncoder frontLeftEncoder = (RelativeEncoder) frontLeftMotor.getEncoder();
    private RelativeEncoder frontRightEncoder = (RelativeEncoder) frontRightMotor.getEncoder();
    private RelativeEncoder backLeftEncoder = (RelativeEncoder) backLeftMotor.getEncoder();
    private RelativeEncoder backRightEncoder = (RelativeEncoder) backRightMotor.getEncoder();

    DifferentialDrive tankDrive = new DifferentialDrive (
        (double leftSpeed) -> {
            frontLeftMotor.set(leftSpeed);
            backLeftMotor.set(leftSpeed);
        }, 
        (double rightSpeed) -> {
            frontRightMotor.set(rightSpeed);
            backRightMotor.set(rightSpeed);
        }
    );
    public double getRobotPosition() {
        double positionAverage = ((backRightEncoder.getPosition() + backLeftEncoder.getPosition() + frontRightEncoder.getPosition() + frontLeftEncoder.getPosition() / (4 * Constants.WHEEL_CIRCUMFERENCE)  ));
        return positionAverage;
    }
    public void drive(double zRotate, double xAxis){
        tankDrive.arcadeDrive(Constants.DRIVE_SPEED * xAxis, Constants.DRIVE_SPEED * zRotate);
        
    }
}