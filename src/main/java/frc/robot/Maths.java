package frc.robot;

public class Maths {
    public static double rotationConversion(double distance){
        double rotations = (distance/Constants.WHEEL_CIRCUMFERENCE);

        return rotations;
    }
}
