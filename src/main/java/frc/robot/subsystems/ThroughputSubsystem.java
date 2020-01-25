package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ThroughputSubsystem extends SubsystemBase {

    private final Spark throughputSpark = new Spark(Constants.THROUGHPUT);

    public void throughputSpeed(double speed) {
        throughputSpark.set(speed);
    }

}