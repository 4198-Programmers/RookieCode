package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveSubsytem;

public class ZeroGyro extends Command{

    private final SwerveSubsytem swerveSubsytem;

    public ZeroGyro(SwerveSubsytem swerveSubsytem) {
        this.swerveSubsytem = swerveSubsytem;
        addRequirements(swerveSubsytem);
    }

    @Override
    public void execute() {
        swerveSubsytem.gyro.reset();
    }
    
}
