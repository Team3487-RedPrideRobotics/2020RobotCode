package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ADriveStraight extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final double max_speed;
    private final boolean reversed;

    public ADriveStraight(final DriveSubsystem driveSubsystem, final double max_speed, boolean reversed) {

        this.driveSubsystem = driveSubsystem;
        this.max_speed = max_speed;
        this.reversed = reversed;
        addRequirements(driveSubsystem);

    }

    @Override
    public void execute() {
        //TODO Drive Straight Code
        if(reversed) {
            driveSubsystem.setSpeed(-max_speed, -max_speed);
        }
        driveSubsystem.setSpeed(max_speed, max_speed);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setSpeed(0,0);
    } 
}