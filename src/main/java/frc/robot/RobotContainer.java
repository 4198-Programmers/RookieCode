package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  // Initialize Subsystems
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Intialize Controllers
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  // Intialize Commands
  private final DriveCommand m_driveCommand = new DriveCommand(m_driverController, m_driveSubsystem);
  private final AutoDriveCommand m_autoDriveCommand = new AutoDriveCommand(m_driveSubsystem);

  // Initialize autonomous commands list
  SendableChooser<Command> m_autoChooser = new SendableChooser<>();

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    configureAutonomousChooser();

    m_driveCommand.schedule();
  }

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
    
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  private void configureAutonomousChooser() {
    m_autoChooser.setDefaultOption("Auto Drive Command", m_autoDriveCommand);
    SmartDashboard.putData("Autonomous Command Chooser", m_autoChooser);
  }

  public Command getAutonomousCommand() {
    // Runs the selected autonomous command
    return m_autoChooser.getSelected();
  }
}
