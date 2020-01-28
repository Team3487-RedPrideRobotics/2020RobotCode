package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ClimbSubsystem;

public class WinchDownCommand extends CommandBase {

    private ClimbSubsystem winchMotor;

    public WinchDownCommand(ClimbSubsystem subsystem) {
        winchMotor = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        winchMotor.winch(0);
    }

    @Override
    public void initialize() {
        winchMotor.winch(Constants.ClimbCommand.winchDownSpeed);
    }

    @Override
    public void execute() {
        winchMotor.winch(Constants.ClimbCommand.winchDownSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}