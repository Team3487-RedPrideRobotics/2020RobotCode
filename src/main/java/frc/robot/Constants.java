/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.ColorShim;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class ControlPanel {
        public static final HashMap<Color, String> COLORMAP = new HashMap<Color, String>() {
            /**
             *Generated Serial ID
             */
            private static final long serialVersionUID = 7460008506773148384L;
    
            {
                put(new ColorShim(0.2146, 0.4704, 0.3149), "Blue");
                put(new ColorShim(0.2551, 0.52245, 0.2224), "Green");
                put(new ColorShim(0.4729, 0.3789, 0.14819), "Red");
                put(new ColorShim(0.3591, 0.50976, 0.131104), "Yellow");
            }
        };
    }
    public static final class SpinCommand {
        public static final double MAX_SPEED = 1/4;
        //The amount of milliseconds between colors to determine if the control panel has stopped.
        public static final long DELTA_COLOR_TIME = 150;

        public static final double COLOR_PER_ROTATION = 1/8;

        public static final int MIN_ROTATIONS = 4;
    }

    public static final class DriveCommand {
        
    }

    public static final class ClimbCommand {
        public static final double raiseSpeed = 0.75;
        public static final double lowerSpeed = -1;
        public static final double winchDownSpeed = 1;
        public static final double winchUpSpeed = -1;
    }

    public static final class Intake {
        public static final double DOWN_SPEED = 0.3;
        public static final double UP_SPEED = -0.3;
        public static final double IN_SPEED = .4;
        public static final double OUT_SPEED = -.5;
    }

    public static final class Outtake {
        public static final double IN_SPEED = -1;
        public static final double OUT_SPEED = 1;
    }

    public static final class Throughput {
        public static final double UP_SPEED = 1;
        public static final double DOWN_SPEED = -1;
    }

    //This class holds all constants for the operator interface.
    //This only uses port numbers, not actual button classes
    //Also, buttons whose axis can be defined with a primitive,
    //may also be used here
    public static final class OI {
        public static final int BUTTON_BOARD = 2;
        public static final int LEFT_STICK = 0;
        public static final int RIGHT_STICK = 1;

        //Commands
        public static final int SPIN_COMMAND = 1;
        public static final int FIND_COLOR_COMMAND = 3;

        public static final int INTAKE_DOWN_COMMAND = 2;
        public static final int INTAKE_UP_COMMAND = 2;

        public static final int INTAKE_IN_COMMAND = 1;
        public static final int INTAKE_OUT_COMMAND = 1;

        public static final int OUTTAKE_IN_COMMAND = 4;
        public static final int OUTTAKE_OUT_COMMAND = 4;

        public static final int THROUGHPUT_UP_COMMAND = 3;
        public static final int THROUGHPUT_DOWN_COMMAND = 3;

        public static final int WINCH_UP_COMMAND = 6;
        public static final int WINCH_DOWN_COMMAND = 7;
    }

    //Motors
    public static final int DRIVE_RIGHT = 0;
    public static final int DRIVE_LEFT = 1;
    public static final int CLIMB_RIGHT = 2;
    public static final int CLIMB_LEFT = 3;
    public static final int OUTTAKE = 4;
    public static final int WINCH = 5;   
    public static final int WHEEL_SPINNER = 6;
    public static final int THROUGHPUT = 7;
    public static final int INTAKE_SPIN = 8;
    public static final int INTAKE_ROTATE = 9;
}
