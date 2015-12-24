/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.wpilibj.communication;

/**
 * Contains the code necessary to communicate between the robot and the driver station.
 */
public final class FRCControl {


    /**
     * The size of the IO configuration data
     */
    public static final int IO_CONFIG_DATA_SIZE = 32;
    /**
     * The size of the user control data
     */
    public static final int USER_CONTROL_DATA_SIZE = 936 - IO_CONFIG_DATA_SIZE;
    /**
     * The size of the user status data
     */
    public static final int USER_STATUS_DATA_SIZE = 984;
    /**
     * The size of the user driver station display data
     */
    public static final int USER_DS_LCD_DATA_SIZE = 128;

    private FRCControl() {
    }

}
