package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoOne extends SequentialCommandGroup {

//TODO add commands

    public AutoOne(DriveSubsystem drive, OuttakeSubsystem outtake) {
        addCommands(new ADriveStraight(drive,-Constants.Auto.One.DRIVE_ONE, 10),
        new AOuttakeCommand(outtake, Constants.Outtake.OUT_SPEED),
        new ADriveStraight(drive,Constants.Auto.One.DRIVE_ONE, 10)
        );
    }

}
