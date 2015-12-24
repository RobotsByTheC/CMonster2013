/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator;

import org.usfirst.frc2084.robotsimulator.wpilibj.Joystick;

/**
 *
 * @author Ben
 */
public class OI {

    Joystick leftJoystick;
    Joystick rightJoystick;

    public OI() {
        leftJoystick = new Joystick(2);
        rightJoystick = new Joystick(1);
    }

    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }
}
