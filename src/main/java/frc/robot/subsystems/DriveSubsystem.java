package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    // Initialize motors
    private CANSparkMax motorLeftFront = new CANSparkMax(Constants.MOTOR_LEFT_ONE_ID, MotorType.kBrushless);
    private CANSparkMax motorLeftBack = new CANSparkMax(Constants.MOTOR_LEFT_TWO_ID, MotorType.kBrushless);

    private CANSparkMax motorRightFront = new CANSparkMax(Constants.MOTOR_RIGHT_ONE_ID, MotorType.kBrushless);
    private CANSparkMax motorRightBack = new CANSparkMax(Constants.MOTOR_RIGHT_TWO_ID, MotorType.kBrushless);

    // How many times it spun
    private RelativeEncoder motorLeftFrontEncoder = motorLeftFront.getEncoder();
    private RelativeEncoder motorLeftBackEncoder = motorLeftBack.getEncoder();

    private RelativeEncoder motorRightFrontEncoder = motorRightFront.getEncoder();
    private RelativeEncoder motorRightBackEncoder = motorRightBack.getEncoder();

    // Groups left and right motors to "leftTankTreadSpeed" and "rightTankTreadSpeed"
    DifferentialDrive tankDrive = new DifferentialDrive(
        (double leftTankTreadSpeed) -> {
            motorLeftFront.set(leftTankTreadSpeed);
            motorLeftBack.set(leftTankTreadSpeed);
        },
        (double rightTankTreadSpeed) -> {
            motorRightFront.set(rightTankTreadSpeed);
            motorRightBack.set(rightTankTreadSpeed);
        }
    );

    public void drive(double zRotate, double xAxis) {
        tankDrive.arcadeDrive(xAxis, zRotate);
    }

    public double getRobotPosition() {
        double positionAverage = ((motorLeftFrontEncoder.getPosition() + motorRightFrontEncoder.getPosition() + motorLeftBackEncoder.getPosition() + motorRightBackEncoder.getPosition()) / (4 * Constants.WHEEL_CIRCUMFERENCE));
        return positionAverage;
    }
}