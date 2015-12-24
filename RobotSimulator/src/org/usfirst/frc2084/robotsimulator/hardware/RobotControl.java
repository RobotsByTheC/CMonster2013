/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.hardware;

import org.usfirst.frc2084.robotsimulator.wpilibj.communication.FRCCommonControlData;

/**
 * A class that allows communication between {@link FRCCommonControlData} and
 * the fake robot. It serves as the "backing native memory" that is normally
 * used with {@link FRCCommonControlData}.
 *
 * @author Ben
 */
public class RobotControl {

    /**
     * An enum representing the possible modes of the robot.
     */
    public enum RobotMode {

        TELEOP,
        AUTONOMOUS,
        TEST,
    }
    /**
     * The index of the packet
     */
    public static /*UINT16*/ int packetIndex;
    /**
     * The control mode e.g. Autonomous, E-stop, enabled ...
     */
    public static /*UINT8*/ short control;
    // { reset, notEStop, enabled, autonomous, fmsAttached, resync, cRIOChkSum, fpgaChkSum }
    /**
     * The state of the digital inputs on the ds
     */
    public static /*UINT8*/ short dsDigitalIn;
    /**
     * The team number from the ds
     */
    public static /*UINT16*/ int teamID;
    /**
     * Which alliance the robot is on
     */
    public static char dsID_Alliance;
    /**
     * The position of the controls on the alliance station wall.
     */
    public static char dsID_Position;
    /**
     * Position of the axes of the first js
     */
    public static byte[] stick0Axes = new byte[6];
    /**
     * Button state of the first js
     */
    public static short stick0Buttons;		// Left-most 4 bits are unused
    /**
     * Position of the axes of the second js
     */
    public static byte[] stick1Axes = new byte[6];
    /**
     * Button state of the second js
     */
    public static short stick1Buttons;		// Left-most 4 bits are unused
    /**
     * Position of the axes of the third js
     */
    public static byte[] stick2Axes = new byte[6];
    /**
     * Button state of the third js
     */
    public static short stick2Buttons;		// Left-most 4 bits are unused
    /**
     * bits Position of the axes of the fourth js
     */
    public static byte[] stick3Axes = new byte[6];
    /**
     * Button state of the fourth js
     */
    public static short stick3Buttons;		// Left-most 4 bits are unused
    //Analog inputs are 10 bit right-justified
    /**
     * Driver Station analog input
     */
    public static short analog1;
    /**
     * Driver Station analog input
     */
    public static short analog2;
    /**
     * Driver Station analog input
     */
    public static short analog3;
    /**
     * Driver Station analog input
     */
    public static short analog4;

    /**
     * Sets the specified axis on the specified stick to the specified value in
     * FRCCommonControlData.
     *
     * @param stick The (zero based) index of the stick
     * @param button The (zero based) index of the button
     * @param value The value to set the button to
     */
    public static void setStickAxis(int stick, int axis, double value) {
        byte bVal = (byte) ((value + 1.0) / 2.0);
        if (axis >= 0 && axis < 6) {
            switch (stick) {
                case 0:
                    stick0Axes[axis] = bVal;
                    return;
                case 1:
                    stick1Axes[axis] = bVal;
                    return;
                case 2:
                    stick2Axes[axis] = bVal;
                    return;
                case 3:
                    stick3Axes[axis] = bVal;
            }
        }
    }

    /**
     * Sets the specified button on the specified stick to the specified value
     * in FRCCommonControlData.
     *
     * @param stick The (zero based) index of the stick
     * @param button The (zero based) index of the button
     * @param value The value to set the button to
     */
    public static void setStickButton(int stick, int button, boolean value) {
        if (button >= 0 && button < 12) {
            switch (stick) {
                case 0:
                    if (value) {
                        stick0Buttons |= (1 << button);
                    } else {
                        stick0Buttons &= ~(1 << button);
                    }
                    return;
                case 1:
                    if (value) {
                        stick1Buttons |= (1 << button);
                    } else {
                        stick1Buttons &= ~(1 << button);
                    }
                    return;
                case 2:
                    if (value) {
                        stick2Buttons |= (1 << button);
                    } else {
                        stick2Buttons &= ~(1 << button);
                    }
                    return;
                case 3:
                    if (value) {
                        stick3Buttons |= (1 << button);
                    } else {
                        stick3Buttons &= ~(1 << button);
                    }
            }
        }
    }

    public static void setMode(RobotMode mode) {
        switch (mode) {
            case AUTONOMOUS:
                control |= FRCCommonControlData.AUTONOMOUS_BIT;
                control &= ~FRCCommonControlData.TEST_MODE_BIT;
                return;
            case TEST:
                control |= FRCCommonControlData.TEST_MODE_BIT;
                control &= ~FRCCommonControlData.AUTONOMOUS_BIT;
                return;
            case TELEOP:
                control &= ~(FRCCommonControlData.AUTONOMOUS_BIT | FRCCommonControlData.TEST_MODE_BIT);
        }
    }

    public static void setEnabled(boolean enabled) {
        if (enabled) {
            control |= FRCCommonControlData.ENABLED_BIT;
        } else {
            control &= ~FRCCommonControlData.ENABLED_BIT;
        }
    }
}
