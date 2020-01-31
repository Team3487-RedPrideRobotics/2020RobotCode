package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class A2DriveStraight extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final Timer timer = new Timer();
    private double moveTime = 0;

    public A2DriveStraight(final DriveSubsystem driveSubsystem, final double max_speed, int feet) {

        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed * 1.57;
        addRequirements(driveSubsystem);
        moveTime = (feet/(12.98*Constants.Auto.One.DRIVE_ONE));

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() >= 7) {
            driveSubsystem.setSpeed(max_speed, max_speed);
            SmartDashboard.putNumber("Drive1 Time", moveTime);
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
        return timer.get() >= moveTime + 7;
    }
}