package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoThree extends SequentialCommandGroup {

    public AutoThree(DriveSubsystem drive, OuttakeSubsystem outtake, ThroughputSubsystem throughput) {
        addCommands(
        //Toward wall 5'
        new ADriveStraight(drive, throughput, 0,-Constants.Auto.DRIVE, 5),
        //Clockwise Rotation
        new ARotate90(drive, Constants.Auto.ROTATE),
        //10.5' Further
        new ADriveStraight(drive, throughput, 0,-Constants.Auto.DRIVE, (31/2)),
        //Counter-Clockwise Rotation
        new ARotate90cc(drive, -Constants.Auto.ROTATE),
        //Touch wall
        new ADriveStraight(drive, throughput, 0, -Constants.Auto.DRIVE2, (550/100)),
        //Eject
        new AOuttakeCommand(outtake, throughput, Constants.Outtake.OUT_SPEED, (7/2))
        );
    }

}
