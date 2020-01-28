package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeUpCommand extends CommandBase {

    private IntakeSubsystem intake;

    public IntakeUpCommand(IntakeSubsystem subsystem) {
        intake = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        intake.rotateSpeed(0);
    }

    @Override
    public void initialize() {
        intake.rotateSpeed(Constants.Intake.UP_SPEED);
    }

    @Override
    public void execute() {
        intake.rotateSpeed(Constants.Intake.UP_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}