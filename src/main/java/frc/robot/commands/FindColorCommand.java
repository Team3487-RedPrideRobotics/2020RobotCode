package frc.robot.commands;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ControlPanelSubsystem;

public class FindColorCommand extends CommandBase {

    private ControlPanelSubsystem controlPanel;
    private String gameData = "";
    SendableChooser<String> debugChooser = new SendableChooser<String>();
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
        put("None", "None");
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
        put("N", "None");
    }};

    public FindColorCommand(ControlPanelSubsystem subsystem) {
        this.controlPanel = subsystem;
        addRequirements(this.controlPanel);
        debugChooser.setDefaultOption("Auto", "auto");
        debugChooser.addOption("Red", "R");
        debugChooser.addOption("Green", "G");
        debugChooser.addOption("Blue", "B");
        debugChooser.addOption("Yellow", "Y");
        SmartDashboard.putData(debugChooser);

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
        
        gameData = debugChooser.getSelected();
        
        if(gameData.equals("auto")) {
            gameData = DriverStation.getInstance().getGameSpecificMessage();
            if (gameData.length() == 0) {
                return false;
            }
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