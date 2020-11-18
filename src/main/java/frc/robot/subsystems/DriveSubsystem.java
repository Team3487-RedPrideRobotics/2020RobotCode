package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    private ShuffleboardTab tab = Shuffleboard.getTab("Drive");
    private NetworkTableEntry leftSpeed = tab.addPersistent("Left Scalar", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1.0, "max", 1)).getEntry();
    private NetworkTableEntry rightSpeed = tab.addPersistent("Right Scalar", 1).withWidget(BuiltInWidgets.kNumberSlider).withProperties(Map.of("min", -1.0, "max", 1)).getEntry();

    private SpeedController leftMotor = new Spark(Constants.DRIVE_LEFT);
    private SpeedController rightMotor = new Spark(Constants.DRIVE_RIGHT);
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

    public void setSpeed(double left, double right) {
        drive.tankDrive(left*leftSpeed.getDouble(1.0), right*rightSpeed.getDouble(1.0));
    }
}