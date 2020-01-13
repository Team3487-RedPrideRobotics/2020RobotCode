package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.ColorShim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants;

public class ControlPanelSubsystem extends SubsystemBase {

    private final Spark spinner = new Spark(Constants.WHEEL_SPINNER);
    private final ColorSensorV3 sensor = new ColorSensorV3(I2C.Port.kOnboard);
    private final ColorMatch matcher = new ColorMatch();
    private final HashMap<Color, String> colorMap = new HashMap<Color, String>() {
        /**
         *Generated Serial ID
         */
        private static final long serialVersionUID = 7460008506773148384L;

        {
            //TODO Maybe put this into a constant
            put(new ColorShim(0.2146, 0.4704, 0.3149), "Blue");
            put(new ColorShim(0.2551, 0.52245, 0.2224), "Green");
            put(new ColorShim(0.4729, 0.3789, 0.14819), "Red");
            put(new ColorShim(0.3591, 0.50976, 0.131104), "Yellow");
        }
    };
    public ControlPanelSubsystem() {
        System.out.println("New Control Panel");
        for (Map.Entry<Color, String> entry : colorMap.entrySet()) {
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
        ColorMatchResult result = matcher.matchClosestColor(sensor.getColor());
        String color = colorMap.get(result.color);
        SmartDashboard.putString("Current Color:", color);
        return color;
    }

}