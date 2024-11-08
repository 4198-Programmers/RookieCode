package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final int MOTOR_FRONT_RIGHT_ID = 1;
  public static final int MOTOR_BACK_RIGHT_ID = 2;
  public static final int MOTOR_FRONT_LEFT_ID = 3;
  public static final int MOTOR_BACK_LEFT_ID = 4;


  public static final double WHEEL_DIAMETER = 8.5;
  public static final double WHEEL_RADIUS = WHEEL_DIAMETER / 2;
  public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

  public static final double SPEED_CAP = 0.5; // Boooooo
}
