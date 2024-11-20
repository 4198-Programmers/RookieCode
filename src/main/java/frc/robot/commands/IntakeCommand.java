package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.LauncherANDIntakeSubsystem;

public class IntakeCommand extends Command {
    LauncherANDIntakeSubsystem launcherSubsystem;
    CommandXboxController controller;

    public IntakeCommand(CommandXboxController controller, LauncherANDIntakeSubsystem launcherSubsystem) {
        this.controller = controller;
        this.launcherSubsystem = launcherSubsystem;

        addRequirements(launcherSubsystem);
    }

    @Override
    public void execute() {
        launcherSubsystem.setLauncherSpeed(-Constants.LAUNCHER_SPEED);

    }
    
    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
    }
}
