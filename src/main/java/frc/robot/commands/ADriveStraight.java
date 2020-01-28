package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ADriveStraight extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final Timer timer = new Timer();
    private double feet = 0;

    public ADriveStraight(final DriveSubsystem driveSubsystem, final double max_speed, double feet) {

        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed;
        this.feet = feet;
        addRequirements(driveSubsystem);

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.setSpeed(max_speed, max_speed);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setSpeed(0,0);
        timer.stop();
    } 

    @Override
    public boolean isFinished() {
        //If the current time is gtoe f
        return timer.get() >= feet/((12.98/100)*Math.abs(max_speed/255));
    }
}