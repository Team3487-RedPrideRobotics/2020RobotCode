package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AOuttakeCommand extends CommandBase {

    private final Timer timer = new Timer();
    private OuttakeSubsystem outtake;
    private ThroughputSubsystem throughput;
    private final int outputTime;

    public AOuttakeCommand(OuttakeSubsystem subsystem, ThroughputSubsystem throughput, final double max_speed_out, final int outputTime) {
        outtake = subsystem;
        this.throughput = throughput;
        this.outputTime = outputTime;
        addRequirements(subsystem);
        addRequirements(throughput);
    }

    @Override
    public void end(boolean interrupted) {
        outtake.outtakeSpeed(0);
        throughput.throughputSpeed(0);
        timer.stop();
    }

    @Override
    public void initialize() {
		timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() >= 0.75 && timer.get() < (outputTime - 0.5)) {
        outtake.outtakeSpeed(Constants.Outtake.OUT_SPEED);
        throughput.throughputSpeed(Constants.Throughput.UP_SPEED);
        SmartDashboard.putNumber("Out Time", timer.get());
        }
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= outputTime;
    }

}