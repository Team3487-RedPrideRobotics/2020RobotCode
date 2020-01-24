package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class OuttakeSubsystem extends SubsystemBase {

    private final Spark outtakeSpark = new Spark(Constants.OUTTAKE);

    public OuttakeSubsystem() {}

    public void outtakeSpeed(double speed) {
        outtakeSpark.set(speed);
    }

}