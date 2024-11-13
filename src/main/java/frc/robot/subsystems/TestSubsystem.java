// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.RelativeEncoder;

// import frc.robot.Constants;

// import com.revrobotics.CANSparkLowLevel.MotorType;

// public class TestSubsystem {
//     CANSparkMax frontRightMotor = new CANSparkMax(Constants.MOTOR_FRONT_RIGHT_ID, MotorType.kBrushless);
//     CANSparkMax frontLeftMotor = new CANSparkMax(Constants.MOTOR_FRONT_LEFT_ID, MotorType.kBrushless);
//     CANSparkMax backRightMotor = new CANSparkMax(2, MotorType.kBrushless);
//     CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);

//     RelativeEncoder frontRightMotorEncoder = frontRightMotor.getEncoder();

//     private void drive(double xAxis, double zRotate) {
//         frontRightMotor.arcadeDrive(xAxis, zRotate);

//     }

//         public double getRobotPosition() {
//         double positionAverage = ((motorFrontLeftEncoder.getPosition() + motorFrontRightEncoder.getPosition() + motorBackLeftEncoder.getPosition() + motorBackRightEncoder.getPosition()) / (4 * Constants.WHEEL_CIRCUMFERENCE));
//         return positionAverage;
//     }
// }
