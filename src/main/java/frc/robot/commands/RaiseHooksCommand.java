package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
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

        if(stick.getRawAxis(1) < 0.25) {
            climb.raiseLeft(Constants.ClimbCommand.raiseSpeed);
            climb.raiseRight(Constants.ClimbCommand.raiseSpeed);
            return;
        }   else if(stick.getRawAxis(1) > 0.75) {
                climb.raiseLeft(Constants.ClimbCommand.lowerSpeed);
            climb.raiseRight(Constants.ClimbCommand.lowerSpeed);
            return;
        }

        //TODO FIX BUG

        climb.raiseLeft(0);
        climb.raiseRight(0);
        
    }

    @Override
    public void end(boolean interrupted) {
        climb.raiseLeft(0);
        climb.raiseRight(0);
    }

}