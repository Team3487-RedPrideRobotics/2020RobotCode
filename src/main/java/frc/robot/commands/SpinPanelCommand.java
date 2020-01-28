package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ControlPanelSubsystem;

//Blue R 0.2146, 0.4704, 0.3149
//Green R 0.2551, 0.52245, 0.2224
//Red 0.4729, 0.3789, 0.14819
//Yellow 0.3591, 0.50976, 0.131104

public class SpinPanelCommand extends CommandBase {
    private final ControlPanelSubsystem controlPanel;
    private double rotations = 0;
    private long prevTime;
    private String prevColor = "";
    private boolean wheelStopped = false;

    public SpinPanelCommand(final ControlPanelSubsystem subsystem) {
        controlPanel = subsystem;
        addRequirements(controlPanel);
        setName("Control Panel Subsystem");
    }

    @Override
    public void initialize() {
        this.rotations = 0;
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
        controlPanel.setSpeed(Constants.SpinCommand.MAX_SPEED);
        String color = controlPanel.getColor();
        countRotations(color, System.currentTimeMillis());
        SmartDashboard.putNumber("Rotations", this.rotations);
        SmartDashboard.putBoolean("Prev color Same", this.wheelStopped);

        prevColor = color;        
    }

    private void countRotations(String result, long currentTime) {
        long deltaTime = currentTime - this.prevTime;
        
        if(prevColor.equals(result)) {

            if(deltaTime > Constants.SpinCommand.DELTA_COLOR_TIME) {
                this.wheelStopped = true;
            }
            return;
        } else {
            this.wheelStopped = false;
        }
        System.out.println("Rotation");
        this.rotations += Constants.SpinCommand.COLOR_PER_ROTATION;

    }

    private boolean rotationsCompleted() {
        return this.rotations >= Constants.SpinCommand.MIN_ROTATIONS;
    }
    
}