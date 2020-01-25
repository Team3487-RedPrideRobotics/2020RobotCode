package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.OuttakeSubsystem;

public class OuttakeOutCommand extends CommandBase {

    private OuttakeSubsystem outtake;

    public OuttakeOutCommand(OuttakeSubsystem subsystem) {
        outtake = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        outtake.outtakeSpeed(0);
    }

    @Override
    public void initialize() {
        outtake.outtakeSpeed(Constants.Outtake.OUT_SPEED);
    }

    @Override
    public void execute() {
        outtake.outtakeSpeed(Constants.Outtake.OUT_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}