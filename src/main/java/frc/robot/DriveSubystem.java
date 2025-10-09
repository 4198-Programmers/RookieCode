package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubystem extends SubsystemBase{
  
    private SparkMaxConfig config1 = new SparkMaxConfig();

    private SparkMaxConfig config2 = new SparkMaxConfig();

    private SparkMax jermey1 = new SparkMax(1, MotorType.kBrushless);

    private SparkMax jermey2 = new SparkMax(2, MotorType.kBrushless);

    private SparkMax jermey3 = new SparkMax(3, MotorType.kBrushless);

    private SparkMax jermey4 = new SparkMax(4, MotorType.kBrushless);

    private DifferentialDrive differentialDrive = new DifferentialDrive(jermey1, jermey3);


    public DriveSubystem(){
        config1.follow(1);
        jermey2.configure(config1, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

        config2.follow(3);
        jermey4.configure(config2, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void jerArcade(double speed, double rotation){
        differentialDrive.arcadeDrive(speed, rotation);

    }

}

