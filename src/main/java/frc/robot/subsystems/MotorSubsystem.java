package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {

  private SparkMax motor = new SparkMax(0, MotorType.kBrushless);

  public MotorSubsystem() {}

  public void runMotor(double speed) {
    motor.set(speed);
  }

  public void stopMotor() {
    motor.set(0.0d);
  }
}
