package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final Spark rotate = new Spark(Constants.INTAKE_ROTATE);
    private final Spark spin = new Spark(Constants.INTAKE_SPIN);

    public IntakeSubsystem() {}

    public void rotateSpeed(double speed) {
        rotate.set(speed);
    }

    public void spinSpeed(double speed) {
        spin.set(speed);
    }

}