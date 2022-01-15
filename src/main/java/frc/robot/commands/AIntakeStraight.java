package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class AIntakeStraight extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final ThroughputSubsystem throughputSubsystem;
    private final double max_speed;
    private final Timer timer = new Timer();
    private double moveTime = 0;

    public AIntakeStraight(final DriveSubsystem driveSubsystem, final IntakeSubsystem intakeSubsystem, final ThroughputSubsystem throughputSubsystem, final double max_speed, int feet) {

        this.throughputSubsystem = throughputSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed * 1.57;
        addRequirements(driveSubsystem);
        moveTime = (feet/(12.98*Constants.Auto.DRIVE));

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() <= 0.15) {
            intakeSubsystem.rotateSpeed(Constants.Intake.DOWN_SPEED);
        }
        driveSubsystem.setSpeed(max_speed, max_speed - 0.01);
        intakeSubsystem.spinSpeed(Constants.Intake.IN_SPEED - 0.05);
        throughputSubsystem.throughputSpeed(Constants.Throughput.UP_SPEED);
        SmartDashboard.putNumber("Drive1 Time", moveTime);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setSpeed(0,0);
        intakeSubsystem.spinSpeed(0);
        throughputSubsystem.throughputSpeed(0);
        timer.stop();
    } 

    @Override
    public boolean isFinished() {
        //If the current time is gtoe f
        return timer.get() >= moveTime;
    }
}