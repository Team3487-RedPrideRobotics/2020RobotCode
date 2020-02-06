package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

//Blue R 0.2146, 0.4704, 0.3149
//Green R 0.2551, 0.52245, 0.2224
//Red 0.4729, 0.3789, 0.14819
//Yellow 0.3591, 0.50976, 0.131104

public class ManualSpinCommand extends CommandBase {
    private final ControlPanelSubsystem controlPanel;
    private final Joystick stick;


    public ManualSpinCommand(ControlPanelSubsystem subsystem, Joystick stick) {
        controlPanel = subsystem;
        this.stick = stick;
        addRequirements(controlPanel);
    }

    @Override
    public void initialize() {
        if (stick.getRawAxis(0) > 0) {
            controlPanel.setSpeed(-Constants.ControlPanelManual.SPEED);
        } else if (stick.getRawAxis(0) < 0) {
            controlPanel.setSpeed(Constants.ControlPanelManual.SPEED);
        } else if (stick.getRawAxis(0) == 0) {
            controlPanel.setSpeed(0);
        }
    }

    @Override
    public void end(final boolean interrupted) {
        controlPanel.setSpeed(0);
    }

    @Override
    public void execute() {
        if (stick.getRawAxis(0) > 0) {
            controlPanel.setSpeed(-Constants.ControlPanelManual.SPEED);
        } else if (stick.getRawAxis(0) < 0) {
            controlPanel.setSpeed(Constants.ControlPanelManual.SPEED);
        } else if (stick.getRawAxis(0) == 0) {
            controlPanel.setSpeed(0);
        }                
    }
    
}