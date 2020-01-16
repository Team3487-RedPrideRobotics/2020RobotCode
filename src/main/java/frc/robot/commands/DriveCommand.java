package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {

    private DriveSubsystem drive;
    private Joystick stickLeft;
    private Joystick stickRight;

    public DriveCommand(DriveSubsystem drive,Joystick stickLeft,Joystick stickRight) {
        this.drive = drive;
        this.stickRight = stickRight;
        this.stickLeft = stickLeft;
        addRequirements(drive);
};

    @Override
    public void execute() {
        drive.setSpeed(-stickLeft.getRawAxis(1), -stickRight.getRawAxis(1));
    }

}