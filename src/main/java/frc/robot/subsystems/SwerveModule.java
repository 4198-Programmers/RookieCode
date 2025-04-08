package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule extends SubsystemBase {

    private SparkMax driveMotor;
    private SparkMax angleMotor;
    private RelativeEncoder relativeAngleEncoder;
    private RelativeEncoder relativeDriveEncoder;
    private SparkMaxConfig driveMotorConfig;
    private SparkMaxConfig angleMotorConfig;
    private CANcoder absoluteAngleEncoder;
    private CANcoderConfiguration absoluteEncoderConfig;
    private Rotation2d angleOffset;
    private SwerveModuleState desiredState;
    private SparkClosedLoopController anglePID;

    public SwerveModule(int driveMotorID, int angleMotorID, int absoluteEncoderID, double angleOffset) {
        driveMotor = new SparkMax(driveMotorID, MotorType.kBrushless);
        angleMotor = new SparkMax(angleMotorID, MotorType.kBrushless);
        
        relativeDriveEncoder = driveMotor.getEncoder();
        relativeAngleEncoder = angleMotor.getEncoder();
        absoluteAngleEncoder = new CANcoder(angleMotorID);

        angleMotorConfig = new SparkMaxConfig();
        driveMotorConfig = new SparkMaxConfig();
        absoluteEncoderConfig = new CANcoderConfiguration();

        anglePID = angleMotor.getClosedLoopController();

        angleMotorConfig
                .idleMode(IdleMode.kBrake)
                .smartCurrentLimit(20);
        angleMotorConfig.closedLoop
                .pid(1, 0, 0)
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .outputRange(-1,1)
                .positionWrappingInputRange(0,1)
                .positionWrappingEnabled(true);
        angleMotorConfig.encoder
                .positionConversionFactor(Constants.SWERVE_ANGLE_GEAR_RATIO);

        driveMotorConfig
                .idleMode(IdleMode.kBrake);
        driveMotorConfig.closedLoop
                .pid(1, 0, 0)
                .outputRange(-1, 1)
                .positionWrappingEnabled(false);
        driveMotorConfig.encoder
                .positionConversionFactor(Constants.SWERVE_ANGLE_GEAR_RATIO)
                .velocityConversionFactor(Constants.SWERVE_ANGLE_GEAR_RATIO);

        absoluteEncoderConfig.MagnetSensor.AbsoluteSensorDiscontinuityPoint = 0.5;
        absoluteEncoderConfig.MagnetSensor.MagnetOffset = angleOffset;
        absoluteEncoderConfig.MagnetSensor.withSensorDirection(Constants.ABSOLUTE_SENSOR_DIRECTION);

        driveMotor.configure(driveMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        angleMotor.configure(angleMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        resetToAbsolute();
    }

    private void resetToAbsolute() {
        Rotation2d position = Rotation2d.fromRotations(absoluteAngleEncoder.getPosition().getValueAsDouble());
        relativeAngleEncoder.setPosition(position.getRotations());
    }

    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(relativeDriveEncoder.getPosition(), getAngle());
    }

    private Rotation2d getAngle() {
        return Rotation2d.fromRotations(relativeAngleEncoder.getPosition());
    }

    public void setDesiredState(SwerveModuleState desiredState) {
        desiredState.optimize(getAngle());
        anglePID.setReference(desiredState.angle.getRotations(), ControlType.kPosition);
        angleMotor.set(desiredState.speedMetersPerSecond / Constants.MAX_VELOCITY_MPS);
    }
    


}
