package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LauncherSubsystem extends SubsystemBase {
    CANSparkMax launcherMotor = new CANSparkMax(Constants.LAUNCHER_MOTOR_ID, MotorType.kBrushless);

    public void setLauncherSpeed(double speed) {
        launcherMotor.set(speed);
    }

    public void stop() {
        launcherMotor.set(0);
    }
}
