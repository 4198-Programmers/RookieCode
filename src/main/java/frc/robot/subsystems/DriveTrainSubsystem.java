import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
    
    private CANSparkMax frontLeftMotor = new CANSparkMax(Constants.DriveConstants.FRONT_LEFT_MOTOR, MotorType.kBrushless);
    private CANSparkMax frontRightMotor = new CANSparkMax(Constants.DriveConstants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
    private CANSparkMax backLeftMotor = new CANSparkMax(Constants.DriveConstants.BACK_LEFT_MOTOR, MotorType.kBrushless);
    private CANSparkMax backRightMotor = new CANSparkMax(Constants.DriveConstants.BACK_RIGHT_MOTOR, MotorType.kBrushless);

    DifferentialDrive tankDrive = new DifferentialDrive(
        (double leftOutput) -> {
            frontLeftMotor.set(leftOutput);
            backLeftMotor.set(leftOutput);
        },
        (double rightOutput) -> {
            frontRightMotor.set(rightOutput);
            BackRightMotor.set(rightOutput);
        });

    public void drive(double zRotate, double xAxis) {
        tankDrive.arcadeDrive(Constants.DRIVE_SPEED * zRotate, Constants.DRIVE_SPEED * xAxis);
    }
}
