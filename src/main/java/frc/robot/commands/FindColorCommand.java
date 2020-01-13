package frc.robot.commands;

import java.util.HashMap;

import edu.wpi.first.wpilibj.util.ColorShim;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ControlPanelSubsystem;

public class FindColorCommand extends CommandBase {

    private ControlPanelSubsystem controlPanel;
    private String gameData;
    private HashMap<String, String> colorShifter = new HashMap<String, String>() {
        /**
        * Generated ID Removes Warnings
        */
        private static final long serialVersionUID = -6767315229175718893L;

        {
        put("Yellow","Green");
        put("Blue","Red");
        put("Green", "Yellow");
        put("Red", "Blue");
    }};
    private HashMap<String, String> interpretColor = new HashMap<String, String>() {
        /**
        * Generated ID Removes Warnings
        */
        private static final long serialVersionUID = -6767315229175718893L;

        {
        put("Y","Yellow");
        put("B","Blue");
        put("G", "Green");
        put("R", "Red");
    }};

    public FindColorCommand(ControlPanelSubsystem subsystem) {
        this.controlPanel = subsystem;
        addRequirements(this.controlPanel);
    }

    @Override
    public void initialize() {
        controlPanel.setSpeed(Constants.SpinCommand.MAX_SPEED);
    }

    @Override
    public void execute() {

        if(gameData.length() == 0) {
            gameData = DriverStation.getInstance().getGameSpecificMessage();
            return;
        }
        String findColor = interpretColor.get(gameData.charAt(0));
        String wheelColor = colorShifter.get(controlPanel.getColor());

    }

}