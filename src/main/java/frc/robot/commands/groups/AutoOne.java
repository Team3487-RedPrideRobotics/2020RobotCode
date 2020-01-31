package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoOne extends SequentialCommandGroup {

    public AutoOne(DriveSubsystem drive, OuttakeSubsystem outtake) {
        addCommands(
        //Drive straight to wall    
        new ADriveStraight(drive,-Constants.Auto.DRIVE, 10),
        //Outtake
        new AOuttakeCommand(outtake, Constants.Outtake.OUT_SPEED),
        //Return to line
        new ADriveStraight(drive,Constants.Auto.DRIVE, 10)
        );
    }

}
