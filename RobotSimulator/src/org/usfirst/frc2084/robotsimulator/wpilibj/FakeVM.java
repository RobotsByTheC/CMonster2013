/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.wpilibj;

import org.usfirst.frc2084.robotsimulator.Robot;
import org.usfirst.frc2084.robotsimulator.hardware.RobotControl;

/**
 *
 * @author Ben
 */
public class FakeVM {

    public static void main(String[] args) {
        new AnalogModule(1);
        new DigitalModule(1);
        RobotControl.setEnabled(true);
        (new Robot()).startApp();
        
    }
}
