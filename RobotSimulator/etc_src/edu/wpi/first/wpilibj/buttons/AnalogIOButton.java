/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc2084.robotsimulator.library.buttons;

import org.usfirst.frc2084.robotsimulator.library.DriverStation;
import org.usfirst.frc2084.robotsimulator.library.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author Greg
 */
public class AnalogIOButton extends Trigger {

    public static double THRESHOLD = 0.5;

    int port;

    public AnalogIOButton(int port) {
        this.port = port;
    }

    public boolean get() {
        try {
            return DriverStation.getInstance().getEnhancedIO().getAnalogIn(port) < THRESHOLD;
        } catch (EnhancedIOException ex) {
            return false;
        }
    }

}
