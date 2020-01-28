package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {

    private SpeedController leftMotor = new Spark(Constants.CLIMB_LEFT);
    private SpeedController rightMotor = new Spark(Constants.CLIMB_RIGHT);
    private SpeedController winch = new Spark(Constants.WINCH);

    public void raiseLeft(double speed) {
        leftMotor.set(speed);
    }

    public void raiseRight(double speed) {
        rightMotor.set(speed);
    }

    public void winch(double speed) {
        winch.set(speed);
    }
}