package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class ControlPanelSubsystem extends SubsystemBase {

    private final Spark spinner = new Spark(0);
    private final ColorSensorV3 sensor = new ColorSensorV3(I2C.Port.kOnboard);

    public ControlPanelSubsystem() {
        System.out.println("New Control Panel");
    }
    
    public void setSpeed(double speed) {
        spinner.set(speed);
    }

    public int getProximity() {
        return sensor.getProximity();
    }

    //Gets 
    public Color getColor() {
        return sensor.getColor();
    }

}