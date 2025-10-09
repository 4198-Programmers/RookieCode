package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{

    private SparkMax jereyLeftFront = new SparkMax(1, MotorType.kBrushless);
    private SparkMax jereyLeftBack = new SparkMax(2, MotorType.kBrushless);
    private SparkMax jereyRightFront = new SparkMax(3, MotorType.kBrushless);
    private SparkMax JereyRightBack = new SparkMax(4, MotorType.kBrushless);

    public DifferentialDrive jereyDifferentialDrive = new DifferentialDrive(jereyLeftFront, jereyRightFront); 

    private SparkMaxConfig leftConfig = new SparkMaxConfig();
    private SparkMaxConfig rightConfig = new SparkMaxConfig();

    
    public DriveSubsystem (){
        leftConfig.follow(1);
        jereyLeftBack.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightConfig.follow(3);
        JereyRightBack.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


    }
    
    public void mortalKombat(double speed, double rotation){
        jereyDifferentialDrive.arcadeDrive(speed, rotation);
    }
}
 