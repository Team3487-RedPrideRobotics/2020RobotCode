package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbSubsystem;

public class RaiseHooksCommand extends CommandBase {

    private ClimbSubsystem climb;
    private Joystick stick;

    public RaiseHooksCommand(ClimbSubsystem climb, Joystick stick) {
        this.climb = climb;
        this.stick = stick;
        addRequirements(climb);
};

    @Override
    public void execute() {

        if(stick.getRawAxis(1) < 0) {
            climb.raiseLeft(Constants.ClimbCommand.raiseSpeed);
            climb.raiseRight(Constants.ClimbCommand.raiseSpeed);
            SmartDashboard.putString("Elevator", "Up");
        } else if(stick.getRawAxis(1) > 0) {
            climb.raiseLeft(Constants.ClimbCommand.lowerSpeed);
            climb.raiseRight(Constants.ClimbCommand.lowerSpeed);
            SmartDashboard.putString("Elevator", "Down");
        } else {
            climb.raiseLeft(0);
            climb.raiseRight(0);
            SmartDashboard.putString("Elevator", "0");
        }
        
    }

    @Override
    public void end(boolean interrupted) {
        climb.raiseLeft(0);
        climb.raiseRight(0);
    }

}