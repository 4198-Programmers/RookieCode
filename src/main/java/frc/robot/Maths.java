package frc.robot;

public class Maths {
    public double rotationConversion(double distance) {
        double rotations = distance / Constants.WHEEL_CIRCUMFERENCE;
        return rotations;
    }
}
