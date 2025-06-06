package frc.robot.subsystems;

import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.Odometry;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveSubsytem extends SubsystemBase {

    private SwerveModule frontLeftSwerveModule, frontRightSwerveModule, backLeftSwerveModule, backRightSwerveModule;
    private Odometry odometry;
    public AHRS gyro = new AHRS(NavXComType.kMXP_SPI);
    
    public SwerveSubsytem() {
        frontLeftSwerveModule = new SwerveModule(
                Constants.FRONT_LEFT_DRIVE_MOTOR_ID, 
                Constants.FRONT_LEFT_ANGLE_MOTOR_ID,
                Constants.FRONT_LEFT_ANGLE_ENCODER_ID, 
                Constants.FRONT_LEFT_ANGLE_OFFSET);
        frontRightSwerveModule = new SwerveModule(
                Constants.FRONT_RIGHT_DRIVE_MOTOR_ID, 
                Constants.FRONT_RIGHT_ANGLE_MOTOR_ID, 
                Constants.FRONT_RIGHT_ANGLE_ENCODER_ID, 
                Constants.FRONT_RIGHT_ANGLE_OFFSET);
        backLeftSwerveModule = new SwerveModule(
                Constants.BACK_LEFT_DRIVE_MOTOR_ID, 
                Constants.BACK_LEFT_ANGLE_MOTOR_ID, 
                Constants.BACK_LEFT_ANGLE_ENCODER_ID, 
                Constants.BAKC_LEFT_ANGLE_OFFSET);
        backRightSwerveModule = new SwerveModule(
                Constants.BACK_RIGHT_DRIVE_MOTOR_ID, 
                Constants.BACK_RIGHT_ANGLE_MOTOR_ID, 
                Constants.BACK_RIGHT_ANGLE_ENCODER_ID, 
                Constants.BACK_RIGHT_ANGLE_OFFSET);

        odometry = new SwerveDriveOdometry(Constants.SWERVE_DRIVE_KINEMATICS, gyro.getRotation2d().times(-1), getSwerveModulePositions());
        resetGyro();
    }

    public void resetGyro() {
        gyro.reset();
    }

    @Override
    public void periodic() {
        odometry.update(gyro.getRotation2d(), getSwerveModulePositions());
    }

    public Pose2d getPose(){
        return odometry.getPoseMeters();
    }

    public SwerveModulePosition[] getSwerveModulePositions() {
        return new SwerveModulePosition[]{
            frontLeftSwerveModule.getPosition(),
            frontRightSwerveModule.getPosition(),
            backLeftSwerveModule.getPosition(),
            backRightSwerveModule.getPosition()
        };
    }

    public void drive(double xSpeed, double ySpeed, double zSpeed, boolean fieldOriented){
        SwerveModuleState[] states;
        if(fieldOriented) {
            states = Constants.SWERVE_DRIVE_KINEMATICS.toSwerveModuleStates(ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed * Constants.MAX_VELOCITY_MPS, ySpeed * Constants.MAX_VELOCITY_MPS, Units.degreesToRadians(zSpeed * 360), gyro.getRotation2d()));
        } else {
            states = Constants.SWERVE_DRIVE_KINEMATICS.toSwerveModuleStates(new ChassisSpeeds(xSpeed * Constants.MAX_VELOCITY_MPS, ySpeed * Constants.MAX_VELOCITY_MPS, zSpeed / 5));
        } 
        setModuleStates(states);
    }

    private void setModuleStates(SwerveModuleState[] states) {
        SwerveDriveKinematics.desaturateWheelSpeeds(states, Constants.MAX_VELOCITY_MPS);
        frontLeftSwerveModule.setDesiredState(states[0]);
        frontRightSwerveModule.setDesiredState(states[1]);
        backLeftSwerveModule.setDesiredState(states[2]);
        backRightSwerveModule.setDesiredState(states[3]);

    }

}
