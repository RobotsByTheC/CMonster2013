/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.library;

//import com.sun.squawk.Isolate;
//import com.sun.squawk.VM;
//import org.usfirst.frc2084.robotsimulator.library.fpga.tGlobal;
import org.usfirst.frc2084.robotsimulator.library.parsing.IUtility;

/**
 * Contains global utility functions
 */
public class Utility implements IUtility {

    /**
     * Make sure that the FPGA is initialized properly before any of these
     * functions are used.
     */
    static {
//        new tGlobal();
    }

    private Utility() {
    }

    /**
     * Return the FPGA Version number. For now, expect this to be 2009.
     *
     * @return FPGA Version number.
     */
    int getFPGAVersion() {
        return 2009;//tGlobal.readVersion();
    }

    /**
     * Return the FPGA Revision number. The format of the revision is 3 numbers.
     * The 12 most significant bits are the Major Revision. the next 8 bits are
     * the Minor Revision. The 12 least significant bits are the Build Number.
     *
     * @return FPGA Revision number.
     */
    long getFPGARevision() {
        return 0;//tGlobal.readRevision();
    }

    /**
     * Read the microsecond timer from the FPGA.
     *
     * @return The current time in microseconds according to the FPGA.
     */
    public static long getFPGATime() {
        return System.nanoTime() / 1000;//SystemtGlobal.readLocalTime();
    }

    /**
     * Control whether to send System.err output to the driver station's error
     * pane.
     *
     * @param enabled if true, send error stream to driver station, otherwise
     * disable sending error stream
     */
    public static void sendErrorStreamToDriverStation(boolean enabled) {
//        final String url = "dserror:org.usfirst.frc2084.robotsimulator.library.Utility"; // the path is just a comment.
//        Isolate isolate = VM.getCurrentIsolate();
//        if (enabled) {
//            isolate.addErr(url);
//        } else {
//            isolate.removeErr(url);
//        }
    }
}
