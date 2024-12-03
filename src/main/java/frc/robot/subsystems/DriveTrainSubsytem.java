package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsytem extends SubsystemBase {
    

    private CANSparkMax leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);

    public DriveTrainSubsytem() {
        leftRearMotor.follow(leftFrontMotor);
        rightRearMotor.follow(rightFrontMotor);
    }
    public void drive(double leftSpeed, double rightSpeed) {
        leftFrontMotor.set(leftSpeed);
        rightFrontMotor.set(rightSpeed);
    }
    

    }
}
