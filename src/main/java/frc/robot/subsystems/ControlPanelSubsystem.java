package frc.robot.subsystems;

import java.util.Map;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ControlPanelSubsystem extends SubsystemBase {

    private final Spark spinner = new Spark(Constants.WHEEL_SPINNER);
    private final ColorSensorV3 sensor = new ColorSensorV3(I2C.Port.kOnboard);
    private final ColorMatch matcher = new ColorMatch();

    public ControlPanelSubsystem() {
        System.out.println("New Control Panel");
        for (Map.Entry<Color, String> entry : Constants.ControlPanel.COLORMAP.entrySet()) {
            this.matcher.addColorMatch(entry.getKey());
        }
    }
    
    public void setSpeed(double speed) {
        spinner.set(speed);
    }

    public int getProximity() {
        return sensor.getProximity();
    }

    //Gets 
    public String getColor() {
        Color cColor = sensor.getColor();
        if(cColor == null) {
            return "None";
        }
        ColorMatchResult result = matcher.matchClosestColor(cColor);
        String color = Constants.ControlPanel.COLORMAP.get(result.color);
        SmartDashboard.putString("Current Color:", color);
        return color;
    }

}