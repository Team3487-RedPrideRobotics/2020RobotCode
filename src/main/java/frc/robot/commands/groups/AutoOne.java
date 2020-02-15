package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoOne extends SequentialCommandGroup {

    // 93% Success
    public AutoOne(DriveSubsystem drive, OuttakeSubsystem outtake, ThroughputSubsystem throughput) {
        addCommands(
        //Drive straight to wall    
        new ADriveStraight(drive, throughput, 0, -Constants.Auto.DRIVE, (114/10)),
        //Outtake
        new AOuttakeCommand(outtake, throughput, Constants.Outtake.OUT_SPEED, (7/2)),
        //Return to line
        new ADriveStraight(drive, throughput, 0, Constants.Auto.DRIVE, (114/10))
        );
    }

}
