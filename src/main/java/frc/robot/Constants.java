/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class SpinCommand {
        public static final double MAX_SPEED = 1;
        //The amount of milliseconds between colors to determine if the control panel has stopped.
        public static final long DELTA_COLOR_TIME = 150;

        public static final double COLOR_PER_ROTATION = 1/8;

        public static final int MIN_ROTATIONS = 3;
    }

    //This class holds all constants for the operator interface.
    //This only uses port numbers, not actual button classes
    //Also, buttons whose axis can be defined with a primitive,
    //may also be used here
    public static final class OI {
        public static final int FIGHT_STICK = 2;
        public static final int LEFT_STICK = 0;
        public static final int RIGHT_STICK = 1;

        //Commands
        public static final int SPIN_COMMAND = 1;
    }

    //Motors
    public static final int WHEEL_SPINNER = 6;
}
