package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Jeremy extends SubsystemBase{
    
    private SparkMax jeremyBackLeft = new SparkMax(3, MotorType.kBrushless);
    private SparkMax jeremyBackRight = new SparkMax(4, MotorType.kBrushless);
    private SparkMax jeremyFrontLeft = new SparkMax(1, MotorType.kBrushless);
    private SparkMax jeremyFrontRight = new SparkMax(2, MotorType.kBrushless);

    DifferentialDrive tankDrive = new DifferentialDrive (
        (double leftOutput) -> {
            jeremyFrontLeft.set(leftOutput);
            jeremyBackLeft.set(leftOutput);
        },
        (double rightOutput) -> {
            jeremyFrontRight.set(rightOutput);
            jeremyBackRight.set(rightOutput);
        }
    );

    public void drive(double rotate, double forward) {
        tankDrive.arcadeDrive(forward, rotate);
    }

    
}
