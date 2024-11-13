package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.DeathSpinCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LauncherCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  // Initialize Subsystems
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();

  // Intialize Controllers
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  // Intialize Commands
  public final DriveCommand m_driveCommand = new DriveCommand(m_driverController, m_driveSubsystem);
  private final AutoDriveCommand m_autoDriveCommand = new AutoDriveCommand(m_driveSubsystem);
  private final DeathSpinCommand m_deathSpinCommand = new DeathSpinCommand(m_driveSubsystem);
  private final LauncherCommand m_launcherCommand = new LauncherCommand(m_driverController, m_launcherSubsystem);


  // Initialize autonomous commands list
  SendableChooser<Command> m_autoChooser = new SendableChooser<>();

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    configureAutonomousChooser();
  }

  private void configureBindings() {
    // Link Launcher to A button here
    m_driverController.a().onTrue(m_launcherCommand);
  }

  private void configureAutonomousChooser() {
    m_autoChooser.setDefaultOption("Auto Drive", m_autoDriveCommand);
    m_autoChooser.addOption("Death Spin", m_deathSpinCommand);

    SmartDashboard.putData("Auto Chooser", m_autoChooser);
  }

  public Command getAutonomousCommand() {
    // Runs the selected autonomous command in SendableChooser list
    return m_autoChooser.getSelected();
  }
}
