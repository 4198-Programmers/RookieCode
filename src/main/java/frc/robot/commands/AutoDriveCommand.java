package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Maths;
import frc.robot.subsystems.driveTrain;


public class AutoDriveCommand extends Command {
    private driveTrain drive;

    double speed = .5;
    double distance = 50;

    public AutoDriveCommand(driveTrain drive) {
        this.drive = drive;

        addRequirements(drive);
    }
    @Override
    public void execute(){
        if (drive.getRobotPosition() < Maths.rotationConversion(distance)){
            drive.drive(0,speed);
        } else{
            end(true);
        }
    }
    @Override
    public void end(boolean interrupted){
        drive.drive(0,0);
    }
}