package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {

    public MotorSubsystem () {}
    
    private CANSparkMax frontIntakeMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
    private CANSparkMax backIntakeMotor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);

    public void setIntakeSpeed (double speed) {
        frontIntakeMotor.set(speed);
    }
}
