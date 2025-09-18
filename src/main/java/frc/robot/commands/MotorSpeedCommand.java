package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class MotorSpeedCommand extends Command {
  private MotorSubsystem motorSubsystem;
  
  public MotorSpeedCommand(MotorSubsystem motorSubsystem) {
    this.motorSubsystem = motorSubsystem;
    addRequirements(motorSubsystem);
  }

  @Override
  public void initialize() {};

  @Override
  public void execute() {
    motorSubsystem.runMotor(0.5);
  };

  @Override
  public void end(boolean interrupted) {
    motorSubsystem.stopMotor();
  };

  @Override
  public boolean isFinished() {
    return false;
  }
}
