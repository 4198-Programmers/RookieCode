package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {
    
    public DriveBase () {}

    private CANSparkMax frontLeftMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

    private CANSparkMax frontRightMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

    private CANSparkMax backLeftMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

    private CANSparkMax backRightMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

}
