package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.JeremeySubystem;

public class JeremeyCommand extends Command{

    private final JeremeySubystem m_JeremeySubystem;

    public JeremeyCommand(JeremeySubystem jeremeySubystem){
        m_JeremeySubystem = jeremeySubystem;
        addRequirements(jeremeySubystem);
    }

    @Override
    public void execute(){
        m_JeremeySubystem.JeremyPringle();
    }
}
