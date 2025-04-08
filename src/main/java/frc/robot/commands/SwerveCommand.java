package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsytem;

public class SwerveCommand extends Command {

    private final SwerveSubsytem swerveSubsytem;
    private Supplier<Double> xSpeed, ySpeed, rotationSpeed;

    public SwerveCommand(SwerveSubsytem swerveSubsytem, Supplier<Double> xSpeed, Supplier<Double> ySpeed, Supplier<Double> rotationSpeed, boolean fieldOriented) {
        this.swerveSubsytem = swerveSubsytem;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.rotationSpeed = rotationSpeed;
        addRequirements(swerveSubsytem);
    }

    @Override
    public void execute() {
        double xSpeedValue = deadband(xSpeed.get(), Constants.DEADBAND);
        double ySpeedValue = deadband(ySpeed.get(), Constants.DEADBAND);
        double rotationSpeedValue = deadband(rotationSpeed.get(), Constants.DEADBAND);
        swerveSubsytem.drive(xSpeedValue, ySpeedValue, rotationSpeedValue, true);
    }

    private double deadband(double value,  double threshold){
        
        if(Math.abs(value) < threshold){
            return 0;
        }
        return value;
    }
    
}
