package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoFive extends SequentialCommandGroup {

//TODO add commands

    public AutoFive(DriveSubsystem drive, ThroughputSubsystem throughput) {
        addCommands(new ADriveStraight(drive, throughput, 0, Constants.Auto.DRIVE, 5));
    }

}
