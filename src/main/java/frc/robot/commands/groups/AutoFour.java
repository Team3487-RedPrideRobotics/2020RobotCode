package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoFour extends SequentialCommandGroup {

    public AutoFour(DriveSubsystem drive, OuttakeSubsystem outtake, ThroughputSubsystem throughput, IntakeSubsystem intake) {
        addCommands(
            new ADriveStraight(drive, throughput, 0, -Constants.Auto.DRIVE, (114/10)),

            new AOuttakeCommand(outtake, throughput, Constants.Outtake.OUT_SPEED, (7/2)),

            new ADriveStraight(drive, throughput, 0, Constants.Auto.DRIVE, 2),

            new ARotateSelectable(drive, (Constants.Auto.ROTATE), 28),

            new ADriveStraight(drive, throughput, 0, Constants.Auto.DRIVE, (215/10)),

            new ARotateSelectable(drive, -Constants.Auto.ROTATE, 32),

            new AIntakeStraight(drive, intake, throughput, Constants.Auto.DRIVE * 0.98, 17),

            new AIntakeStraight(drive, intake, throughput, 0, 100)
            
            );
    }

}
