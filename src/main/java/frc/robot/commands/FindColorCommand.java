package frc.robot.commands;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DriverStation;
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
    public void end(final boolean interrupted) {
        controlPanel.setSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return main();
    }

    @Override
    public void execute() {

        main();

    }

    private boolean main() {
        if(gameData.length() == 0) {
            gameData = DriverStation.getInstance().getGameSpecificMessage();
            return false;
        }
        String findColor = interpretColor.get(gameData.substring(0, 1));
        String wheelColor = colorShifter.get(controlPanel.getColor());

        if(findColor.equals(wheelColor)) {
            controlPanel.setSpeed(0);
            return true;
        }

        return false;
    }

}