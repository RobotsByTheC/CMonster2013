/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

import org.usfirst.frc2084.robotsimulator.library.ADXL345_I2C;

/**
 *
 * @author Ben
 */
public class ADXL345_I2CComponent extends Component<I2CModule, ADXL345_I2C> {

    public ADXL345_I2CComponent(I2CModule module, ADXL345_I2C disp) {
        super(module, "ADXL345 I2C Accelerometer", disp);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
