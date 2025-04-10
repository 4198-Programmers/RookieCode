// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Define Joysticks and/or Controllers
  public final CommandXboxController xboxController;

  // Define Subsystems
  private DriveSubsystem driveSubsystem;

  // Define Commands
  public DriveCommand driveCommand;
  public AutoDriveCommand autoDriveCommand;

  SendableChooser<Command> autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Initialize joysticks/controllers
    xboxController = new CommandXboxController(Constants.CONTROLLER_PORT);

    // Initialize subsystems
    driveSubsystem = new DriveSubsystem();

    // Initialize commands
    driveCommand = new DriveCommand(driveSubsystem, xboxController);
    autoDriveCommand = new AutoDriveCommand(driveSubsystem, 24);

    // Configure the SendableChooser
    configureAutoChooser();
    // Configure the button bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {}

  /**
   * Configures the SendableChooser by defining the chooser, adding commands, then putting them on the dashboard.
   */
  private void configureAutoChooser() {
    autoChooser = new SendableChooser<>();
    autoChooser.setDefaultOption("Auto Drive Command", autoDriveCommand);
    SmartDashboard.putData(autoChooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoChooser.getSelected();
  }
}
