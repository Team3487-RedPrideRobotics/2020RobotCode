package frc.robot.commands;

import java.util.HashMap;
import java.util.Map;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.ColorShim;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelSubsystem;

//Blue R 0.2146, 0.4704, 0.3149
//Green R 0.2551, 0.52245, 0.2224
//Red 0.4729, 0.3789, 0.14819
//Yellow 0.3591, 0.50976, 0.131104

public class SpinPanelCommand extends CommandBase {
    private final ControlPanelSubsystem controlPanel;
    private final ColorMatch matcher = new ColorMatch();
    private Map<Color,String> colorMap;
    private double rotations = 0;
    private long prevTime;
    private Color prevColor;
    private boolean wheelStopped = false;

    public SpinPanelCommand(final ControlPanelSubsystem subsystem) {
        controlPanel = subsystem;
        addRequirements(controlPanel);
        setName("Control Panel Subsystem");
        colorMap = new HashMap<Color, String>() {
            /**
             *Generated Serial ID
             */
            private static final long serialVersionUID = 7460008506773148384L;

            {
                put(new ColorShim(0.2146, 0.4704, 0.3149), "Blue");
                put(new ColorShim(0.2551, 0.52245, 0.2224), "Green");
                put(new ColorShim(0.4729, 0.3789, 0.14819), "Red");
                put(new ColorShim(0.3591, 0.50976, 0.131104), "Yellow");
            }
        };
    }

    @Override
    public void initialize() {
        this.rotations = 0;
        for (Map.Entry<Color, String> entry : colorMap.entrySet()) {
            this.matcher.addColorMatch(entry.getKey());
        }

    }

    @Override
    public void end(final boolean interrupted) {
        controlPanel.setSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return rotationsCompleted() && wheelStopped;
    }

    @Override
    public void execute() {
        controlPanel.setSpeed(0.75);
        Color color = controlPanel.getColor();
        ColorMatchResult result = matcher.matchClosestColor(color);
        displayColor(result);
        countRotations(result, System.currentTimeMillis());
        SmartDashboard.putNumber("Rotations", this.rotations);
        SmartDashboard.putBoolean("Prev color Same", this.wheelStopped);

        prevColor = result.color;        
    }

    private void displayColor(ColorMatchResult result) {
        SmartDashboard.putString("Color:", colorMap.get(result.color));
        SmartDashboard.putString("Confidence", String.format("%.2f%%",result.confidence*100));
    }

    private void countRotations(ColorMatchResult result, long currentTime) {
        long deltaTime = currentTime - this.prevTime;
        
        if(prevColor==result.color) {

            if(deltaTime > 1000) {
                this.wheelStopped = true;
            }
            return;
        } else {
            this.wheelStopped = false;
        }
        System.out.println("Rotation");
        this.rotations += (double) 1/8;

    }

    private boolean rotationsCompleted() {
        return this.rotations >= 3;
    }
    
}