// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

public static final double SWERVE_ANGLE_GEAR_RATIO = 1 / 12.8;

public static final double DRIVETRAIN_LENGTH = Units.inchesToMeters(29.75);  //Need to be distance between wheels
public static final double DRIVETRAIN_WIDTH = Units.inchesToMeters(29.75);

public static final double MAX_VELOCITY_MPS = Units.feetToMeters(14.75);

public static final double MAX_ROTATIONAL_VELOCITY = MAX_VELOCITY_MPS / Math.hypot(
      SWERVE_ANGLE_GEAR_RATIO / 2, 
      SWERVE_ANGLE_GEAR_RATIO / 2);

//Swerve Front Left
public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 1;
public static final int FRONT_LEFT_ANGLE_MOTOR_ID = 2;
public static final int FRONT_LEFT_ANGLE_ENCODER_ID = 13;
public static final double FRONT_LEFT_ANGLE_OFFSET = 0.380859375;

//Swerve Front Right
public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 3;
public static final int FRONT_RIGHT_ANGLE_MOTOR_ID = 4;
public static final int FRONT_RIGHT_ANGLE_ENCODER_ID = 15;
public static final double FRONT_RIGHT_ANGLE_OFFSET = -0.140380859375;

//Swerve Back Left
public static final int BACK_LEFT_DRIVE_MOTOR_ID = 7;
public static final int BACK_LEFT_ANGLE_MOTOR_ID = 8;
public static final int BACK_LEFT_ANGLE_ENCODER_ID = 14;
public static final double BAKC_LEFT_ANGLE_OFFSET = 0.04443359375;

//Swerve Back Right
public static final int BACK_RIGHT_DRIVE_MOTOR_ID = 5;
public static final int BACK_RIGHT_ANGLE_MOTOR_ID = 6;
public static final int BACK_RIGHT_ANGLE_ENCODER_ID = 16;
public static final double BACK_RIGHT_ANGLE_OFFSET = 0.42333984375; 

//Swerve General

public static final double ROBOT_BASE_LENGTH = Units.inchesToMeters(29.75); 
  public static final double ROBOT_BASE_WIDTH = Units.inchesToMeters(29.75);

  public static final double X_FROM_CENTER = ROBOT_BASE_LENGTH / 2;
  public static final double Y_FROM_CENTER = ROBOT_BASE_WIDTH / 2;

  public static final double FRONT_LEFT_X_LOCATION = X_FROM_CENTER;
  public static final double FRONT_LEFT_Y_LOCATION = Y_FROM_CENTER;

  public static final double FRONT_RIGHT_X_LOCATION = X_FROM_CENTER;
  public static final double FRONT_RIGHT_Y_LOCATION = -Y_FROM_CENTER;

  public static final double BACK_LEFT_X_LOCATION = -X_FROM_CENTER;
  public static final double BACK_LEFT_Y_LOCATION = Y_FROM_CENTER;

  public static final double BACK_RIGHT_X_LOCATION = -X_FROM_CENTER;
  public static final double BACK_RIGHT_Y_LOCATION = -Y_FROM_CENTER;

public static final SwerveDriveKinematics SWERVE_DRIVE_KINEMATICS = new SwerveDriveKinematics(
    new Translation2d(FRONT_LEFT_X_LOCATION, FRONT_LEFT_Y_LOCATION),
    new Translation2d(FRONT_RIGHT_X_LOCATION, FRONT_RIGHT_Y_LOCATION),
    new Translation2d(BACK_LEFT_X_LOCATION, BACK_LEFT_Y_LOCATION),
    new Translation2d(BACK_RIGHT_X_LOCATION, BACK_RIGHT_Y_LOCATION));

public static final SensorDirectionValue ABSOLUTE_SENSOR_DIRECTION = SensorDirectionValue.CounterClockwise_Positive;

public static final double DEADBAND = 0.05;
}
