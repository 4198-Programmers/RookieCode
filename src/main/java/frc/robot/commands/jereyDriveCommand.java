package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class jereyDriveCommand extends Command {
    
    private DriveSubsystem driveSubsystem;

    private double speed;
    private double rotation;

    public jereyDriveCommand(DriveSubsystem driveSubsystem, double speed, double rotation){

        speed = speed;
        rotation = rotation;
        driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.mortalKombat(speed, rotation);
    }


}
