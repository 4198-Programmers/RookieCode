package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.SwerveSubsytem;

public class AutoContainer extends SubsystemBase {

    SwerveSubsytem swerveSubsytem;

    public AutoContainer(SwerveSubsytem swerveSubsytem) {
        this.swerveSubsytem = swerveSubsytem;
    }

    public void setupAutoOptions(SendableChooser<Command> SendableChooser){
        SendableChooser.setDefaultOption("Test", swerveSubsytem.getAutonomousCommand("Test"));
        SendableChooser.addOption("Other Test", swerveSubsytem.getAutonomousCommand("Other Test"));
    }
    
}
