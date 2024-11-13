package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  // Motors
  public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 1;
  public static final int BACK_RIGHT_DRIVE_MOTOR_ID = 2;
  public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 3;
  public static final int BACK_LEFT_DRIVE_MOTOR_ID = 4;

  public static final int LAUNCHER_MOTOR_ID = 0;

  // Various Lengths
  public static final double WHEEL_DIAMETER = 8.5;
  public static final double WHEEL_RADIUS = WHEEL_DIAMETER / 2;
  public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
  public static final double SPEED_CAP = 0.5; // Boooooo

}
