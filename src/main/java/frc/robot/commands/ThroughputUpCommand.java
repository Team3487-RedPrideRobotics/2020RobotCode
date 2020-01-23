package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ThroughputSubsystem;

public class ThroughputUpCommand extends CommandBase {

    private ThroughputSubsystem throughput;

    public ThroughputUpCommand(ThroughputSubsystem subsystem) {
        throughput = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void end(boolean interrupted) {
        throughput.throughputSpeed(0);
    }

    @Override
    public void initialize() {
        throughput.throughputSpeed(Constants.Throughput.UP_SPEED);
    }

    @Override
    public void execute() {
        throughput.throughputSpeed(Constants.Throughput.UP_SPEED);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}