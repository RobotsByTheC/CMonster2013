/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.hardware;

import org.usfirst.frc2084.robotsimulator.hardware.crio.cRIO;
import org.usfirst.frc2084.robotsimulator.wpilibj.AnalogModule;
import org.usfirst.frc2084.robotsimulator.wpilibj.DigitalModule;

/**
 *
 * @author Ben Wolsieffer
 */
public class FakeRobot {
    
    public static void initHardware() {
        cRIO.getInstance();
        cRIO.setType(cRIO.Type.II);
        AnalogModule.getInstance(1);
        new DigitalModule(2);
    }
    
}
