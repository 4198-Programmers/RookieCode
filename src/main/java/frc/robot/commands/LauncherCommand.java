package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.LauncherSubsystem;

public class LauncherCommand extends Command {
    LauncherSubsystem launcherSubsystem;
    CommandXboxController controller;
    double speed = 1;

    public LauncherCommand(CommandXboxController controller, LauncherSubsystem launcherSubsystem) {
        this.launcherSubsystem = launcherSubsystem;
        this.controller = controller;

        addRequirements(launcherSubsystem);
    }

    @Override
    public void execute() {
        launcherSubsystem.setLauncherSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        launcherSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }



}
