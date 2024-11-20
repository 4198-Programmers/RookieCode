package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LauncherANDIntakeSubsystem extends SubsystemBase {
    private CANSparkMax launcherMotorRight = new CANSparkMax(Constants.LAUNCHER_MOTOR_RIGHT_ID, MotorType.kBrushless);
    private CANSparkMax launcherMotorLeft = new CANSparkMax(Constants.LAUNCHER_MOTOR_LEFT_ID, MotorType.kBrushless);

    public void setLauncherSpeed(double speed) {
        launcherMotorRight.set(-speed);
        launcherMotorLeft.set(speed);
    }

    public void stop() {
        launcherMotorRight.set(0);
        launcherMotorLeft.set(0);
    }
}
