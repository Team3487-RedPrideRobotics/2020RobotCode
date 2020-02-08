package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ARotateSelectable extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final double rotation;
    private final double percent;
    private final double circumference;
    private final double inchesPerSecond;
    private final double moveTime;
    private final Timer timer = new Timer();

    public ARotateSelectable(final DriveSubsystem driveSubsystem, final double max_speed, final int rotation) {

        this.rotation = rotation;
        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed;
        percent = (rotation/360);
        circumference = (21.5*3.14159265358);
        inchesPerSecond = 155.76;
        moveTime = 100*((percent * circumference)/(max_speed * inchesPerSecond));
        addRequirements(driveSubsystem);
        
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.setSpeed(-max_speed, max_speed);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setSpeed(0,0);
        timer.stop();
    } 

    @Override
    public boolean isFinished() {
        //If the current time is gtoe f
        return timer.get() >= moveTime + 0.1;
    }
}