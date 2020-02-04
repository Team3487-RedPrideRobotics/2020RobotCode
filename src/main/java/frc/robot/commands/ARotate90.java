package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ARotate90 extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final Timer timer = new Timer();

    public ARotate90(final DriveSubsystem driveSubsystem, final double max_speed) {

        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed;
        addRequirements(driveSubsystem);
        
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() >= 0.1) {
        driveSubsystem.setSpeed((max_speed * 0.75), -max_speed + 0.05);
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setSpeed(0,0);
        timer.stop();
    } 

    @Override
    public boolean isFinished() {
        //If the current time is gtoe f
        return timer.get() >= 1.375;
    }
}