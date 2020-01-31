package frc.robot.commands.groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ADriveStraight;
import frc.robot.subsystems.DriveSubsystem;

public class AutoThree extends SequentialCommandGroup {

//TODO add commands

    public AutoThree(DriveSubsystem drive) {
        addCommands(new ADriveStraight(drive,Constants.Auto.One.DRIVE_ONE, 5));
    }

}
