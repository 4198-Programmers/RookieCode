package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBaseSubsystem extends SubsystemBase{
    
public DriveBaseSubsystem() {}

    private CANSparkMax frontLeftMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax frontRightMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax backLeftMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax backRightMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

}
