package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubystem extends SubsystemBase{
    
    private SparkMax jeremysRightFrontMotor = new SparkMax(2, MotorType.kBrushless);
    private SparkMax jeremysRightBackMotor = new SparkMax(4, MotorType.kBrushless);
    private SparkMax jeremysLeftFrontMotor = new SparkMax(1, MotorType.kBrushless);
    private SparkMax jeremysLeftBackMotor = new SparkMax(3, MotorType.kBrushless);

    private DifferentialDrive tankDrive = new DifferentialDrive(
        (double leftMotorSpeed) -> {
            jeremysLeftBackMotor.set(leftMotorSpeed);
            jeremysLeftFrontMotor.set(leftMotorSpeed);
        }, 
        (double rightMotorSpeed) -> {
            jeremysRightBackMotor.set(rightMotorSpeed);
            jeremysRightFrontMotor.set(rightMotorSpeed);
        });

    public MotorSubystem() {}

    public void drive(double xSpeed, double zRotation) {
        tankDrive.arcadeDrive(xSpeed, zRotation);
    }


}
