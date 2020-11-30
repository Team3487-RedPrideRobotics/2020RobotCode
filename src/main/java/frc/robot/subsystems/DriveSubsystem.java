package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.kauailabs.navx.frc.AHRS;


public class DriveSubsystem extends SubsystemBase {

    private SpeedController leftMotor = new Spark(Constants.DRIVE_LEFT);
    private SpeedController rightMotor = new Spark(Constants.DRIVE_RIGHT);
    private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

    public DriveSubsystem() {
        
    }
    public void setSpeed(double left, double right) {
        drive.tankDrive(left, right);
    }
}