package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class A2DriveStraight extends CommandBase {
    //Put these into existence
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final Timer timer = new Timer();
    private double moveTime = 0;

    public A2DriveStraight(final DriveSubsystem driveSubsystem, final double max_speed, int feet) {
        //Defines the subsystem through whole doc
        this.driveSubsystem = driveSubsystem;
        //Set max speed to 157% of auto capability
        this.max_speed = max_speed * 1.57;
        //Make these numbers use the drive train
        addRequirements(driveSubsystem);
        //Find how long to move
        moveTime = (feet/(12.98*Constants.Auto.DRIVE));

    }

    @Override
    public void initialize() {
        //Set timer to 0 and start it
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        //If we wait 7 seconds, then go to port
        //Display the move time
        if (timer.get() >= 7) {
            driveSubsystem.setSpeed(max_speed, max_speed);
            SmartDashboard.putNumber("Drive1 Time", moveTime);
        }
    }

    @Override
    public void end(boolean interrupted) {
        //Stop the timer and bot
        driveSubsystem.setSpeed(0,0);
        timer.stop();
    } 

    @Override
    public boolean isFinished() {
        //Go back to the rest of the "auto" if we
        //have moved for however long we need to
        return timer.get() >= moveTime + 7;
    }
}