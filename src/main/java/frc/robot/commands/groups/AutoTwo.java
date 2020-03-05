package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


public class AutoTwo extends SequentialCommandGroup {
        //86% success
    public AutoTwo(final DriveSubsystem drive, final OuttakeSubsystem outtake, final ThroughputSubsystem throughput) {
            addCommands(
            //Drive straight to wall after 7s   
            new A2DriveStraight(drive,-Constants.Auto.DRIVE, (115/10)),
            //Outtake shortly
            new AOuttakeCommand(outtake, throughput, Constants.Outtake.OUT_SPEED, (7/2)),
            //Return to line
            new ADriveStraight(drive, throughput, 0, Constants.Auto.DRIVE, (115/10))
            );
        
    }

}
