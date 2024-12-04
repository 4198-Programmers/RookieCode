package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase  {
    
    public DriveBase() {}

    private CANSparkMax frontLeftMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);

    private CANSparkMax frontRightMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);

    private CANSparkMax backRightMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);

    private CANSparkMax backLeftMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);

}
