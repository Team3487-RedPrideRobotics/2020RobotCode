package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoThree extends SequentialCommandGroup {

    public AutoThree(DriveSubsystem drive, OuttakeSubsystem outtake) {
        addCommands(
        //Toward wall 5'
        new ADriveStraight(drive,-Constants.Auto.DRIVE, 5),
        //Clockwise Rotation
        new ARotate90(drive, Constants.Auto.ROTATE2),
        //10.5' Further
        new ADriveStraight(drive,-Constants.Auto.DRIVE, (31/2)),
        //Counter-Clockwise Rotation
        new ARotate90cc(drive, -Constants.Auto.ROTATE),
        //Touch wall
        new ADriveStraight(drive, -Constants.Auto.DRIVE2, (11/2)),
        //Eject
        new AOuttakeCommand(outtake, Constants.Outtake.OUT_SPEED)
        );
    }

}
