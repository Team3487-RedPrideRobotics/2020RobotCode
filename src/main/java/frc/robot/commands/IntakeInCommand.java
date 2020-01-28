package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeInCommand extends CommandBase {

    private IntakeSubsystem intake;

    public IntakeInCommand(IntakeSubsystem subsystem) {
        intake = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        intake.spinSpeed(0);
    }

    @Override
    public void initialize() {
        intake.spinSpeed(Constants.Intake.IN_SPEED);
    }

    @Override
    public void execute() {
        intake.spinSpeed(Constants.Intake.IN_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}