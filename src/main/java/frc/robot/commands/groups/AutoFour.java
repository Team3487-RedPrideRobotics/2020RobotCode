package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoFour extends SequentialCommandGroup {

//TODO add commands

    public AutoFour(DriveSubsystem drive, OuttakeSubsystem outtake, ThroughputSubsystem throughput, IntakeSubsystem intake) {
        addCommands(
            new ADriveStraight(drive, -Constants.Auto.DRIVE, (114/10)),

            new AOuttakeCommand(outtake, throughput, Constants.Outtake.OUT_SPEED, (7/2)),

            new ADriveStraight(drive, Constants.Auto.DRIVE, 2),

            new ARotateSelectable(drive, Constants.Auto.ROTATE, 36),

            new ADriveStraight(drive, Constants.Auto.DRIVE, (210/10)),

            new ARotateSelectable(drive, -Constants.Auto.DRIVE, 36)
            );
    }

}
