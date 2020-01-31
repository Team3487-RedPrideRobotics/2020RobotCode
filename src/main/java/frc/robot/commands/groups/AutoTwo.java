package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


public class AutoTwo extends SequentialCommandGroup {

//TODO add commands

    public AutoTwo(final DriveSubsystem drive, final OuttakeSubsystem outtake) {
            addCommands(new A2DriveStraight(drive,-Constants.Auto.One.DRIVE_ONE, 10),
            new AOuttakeCommand(outtake, Constants.Outtake.OUT_SPEED),
            new ADriveStraight(drive,Constants.Auto.One.DRIVE_ONE, 10)
            );
        
    }

}
