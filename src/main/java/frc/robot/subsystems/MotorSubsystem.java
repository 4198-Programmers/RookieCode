package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorSubsystem extends SubsystemBase {
 
private CANSparkMax testMotor = new CANSparkMax(Constants.DriveConstants.FRONT_LEFT_MOTOR, MotorType.kBrushless);

  public void runMotor() {
        testMotor.set(0.2);
  }  

    public void stopMotor() {
        testMotor.stopMotor();
    }

}
