package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AOuttakeCommand extends CommandBase {

    private final Timer timer = new Timer();
    private OuttakeSubsystem outtake;

    public AOuttakeCommand(OuttakeSubsystem subsystem, final double max_speed_out) {
        outtake = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        outtake.outtakeSpeed(0);
        timer.stop();
    }

    @Override
    public void initialize() {
		timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() >= 0.75 && timer.get() < 1.75) {
        outtake.outtakeSpeed(Constants.Outtake.OUT_SPEED);
        SmartDashboard.putNumber("Out Time", timer.get());
        }
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= 2;
    }

}