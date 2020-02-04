/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.commands.groups.*;
import frc.robot.subsystems.*;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ClimbSubsystem climbSubsystem = new ClimbSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final OuttakeSubsystem outtakeSubsystem = new OuttakeSubsystem();
  private final ThroughputSubsystem throughputSubsystem = new ThroughputSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final SpinPanelCommand spinPanelCommand = new SpinPanelCommand(controlPanelSubsystem);
  private final FindColorCommand findColorCommand = new FindColorCommand(controlPanelSubsystem);
  private final IntakeDownCommand intakeDownCommand = new IntakeDownCommand(intakeSubsystem);
  private final IntakeUpCommand intakeUpCommand = new IntakeUpCommand(intakeSubsystem);
  private final IntakeInCommand intakeInCommand = new IntakeInCommand(intakeSubsystem);
  private final IntakeOutCommand intakeOutCommand = new IntakeOutCommand(intakeSubsystem);
  private final OuttakeOutCommand outtakeOutCommand = new OuttakeOutCommand(outtakeSubsystem);
  private final OuttakeInCommand outtakeInCommand = new OuttakeInCommand(outtakeSubsystem);
  private final ThroughputUpCommand throughputUpCommand = new ThroughputUpCommand(throughputSubsystem);
  private final ThroughputDownCommand throughputDownCommand = new ThroughputDownCommand(throughputSubsystem);
  private final WinchUpCommand winchUpCommand = new WinchUpCommand(climbSubsystem);
  private final WinchDownCommand winchDownCommand = new WinchDownCommand(climbSubsystem);
  private SendableChooser<CommandGroupBase> chooser;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    sendableChooser();
    // Configure the button bindings
    configureButtonBindings();

  }

  private void sendableChooser() {

    SendableChooser<CommandGroupBase> chooser = new SendableChooser<CommandGroupBase>();

    chooser.setDefaultOption("One", new AutoOne(driveSubsystem, outtakeSubsystem));
    chooser.addOption("Two", new AutoTwo(driveSubsystem, outtakeSubsystem));
    chooser.addOption("Three", new AutoThree(driveSubsystem, outtakeSubsystem));
    chooser.addOption("Four", new AutoFour(driveSubsystem));
    chooser.addOption("Super Secret", new AutoFive(driveSubsystem));
    
    //this.chooser IS A POINTER
    this.chooser = chooser;
    System.out.println("Sent Chooser");
    SmartDashboard.putData("Auto Mode", chooser);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Joystick stick1 = new Joystick(Constants.OI.LEFT_STICK);
    Joystick stick2 = new Joystick(Constants.OI.RIGHT_STICK);
    Joystick stick3 = new Joystick(Constants.OI.BUTTON_BOARD);
    JoystickButton spinButton = new JoystickButton(stick3, Constants.OI.SPIN_COMMAND); 
    JoystickButton findColorButton = new JoystickButton(stick3, Constants.OI.FIND_COLOR_COMMAND);
    JoystickButton intakeDownButton = new JoystickButton(stick1, Constants.OI.INTAKE_DOWN_COMMAND);
    JoystickButton intakeUpButton = new JoystickButton(stick2, Constants.OI.INTAKE_UP_COMMAND);
    JoystickButton intakeInButton = new JoystickButton(stick3, Constants.OI.INTAKE_IN_COMMAND);
    JoystickButton intakeOutButton = new JoystickButton(stick3, Constants.OI.INTAKE_OUT_COMMAND);
    JoystickButton outtakeInButton = new JoystickButton(stick1, Constants.OI.OUTTAKE_IN_COMMAND);
    JoystickButton outtakeOutButton = new JoystickButton(stick2, Constants.OI.OUTTAKE_OUT_COMMAND);
    JoystickButton throughputUpButton1 = new JoystickButton(stick2, Constants.OI.OUTTAKE_IN_COMMAND);
    JoystickButton throughputDownButton1 = new JoystickButton(stick1, Constants.OI.OUTTAKE_OUT_COMMAND);
    JoystickButton throughputUpButton2 = new JoystickButton(stick3, Constants.OI.INTAKE_IN_COMMAND);
    JoystickButton throughputDownButton2 = new JoystickButton(stick3, Constants.OI.INTAKE_OUT_COMMAND);
    JoystickButton winchUpButton = new JoystickButton(stick3, Constants.OI.WINCH_UP_COMMAND);
    JoystickButton winchDownButton = new JoystickButton(stick3, Constants.OI.WINCH_DOWN_COMMAND);

    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, stick1, stick2));
    
    spinButton.whenPressed(spinPanelCommand);
    findColorButton.whenPressed(findColorCommand);

    RaiseHooksCommand raiseHooksCommand = new RaiseHooksCommand(climbSubsystem, stick3);
    climbSubsystem.setDefaultCommand(raiseHooksCommand);


    ManualSpinCommand manualSpinCommand = new ManualSpinCommand(controlPanelSubsystem, stick3);
    

    intakeDownButton.whileHeld(intakeDownCommand);
    intakeUpButton.whileHeld(intakeUpCommand);
    intakeOutButton.whileHeld(intakeOutCommand);
    intakeInButton.whileHeld(intakeInCommand);
    
    outtakeOutButton.whileHeld(outtakeOutCommand);
    outtakeInButton.whileHeld(outtakeInCommand);

    throughputUpButton1.whileHeld(throughputUpCommand);
    throughputDownButton1.whileHeld(throughputDownCommand);

    throughputUpButton2.whileHeld(throughputUpCommand);
    throughputDownButton2.whileHeld(throughputDownCommand);

    winchDownButton.whileHeld(winchDownCommand);
    winchUpButton.whileHeld(winchUpCommand);

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    
    return chooser.getSelected();
  }
}
