/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.wpilibj;

import java.util.HashMap;
import org.usfirst.frc2084.robotsimulator.hardware.crio.cRIO;
import org.usfirst.frc2084.robotsimulator.wpilibj.communication.ModulePresence;

/**
 * Class representing a digital module
 *
 * @author Ben Wolsieffer
 */
public class DigitalModule extends Module {

    private static final int PWM_OUTPUTS = 10; // number of PWN outputs on the sidecar
    private static final int DIGITAL_IO_PORTS = 14; // number of digital I/O ports
    private static final int RELAY_OUTPUTS = 8;  // number of relay outputs
    private static final int I2C_PORTS = 4;  // number of I2C ports
    private HashMap<Integer, I2C> i2cComponents = new HashMap<>(I2C_PORTS);

    public DigitalModule(int slot) {
        super(ModulePresence.ModuleType.kDigital, slot);
        cRIO.getInstance().add(this);
    }

    /**
     * Return an I2C object for this digital module
     *
     * @param address The device address.
     * @return The associated I2C object.
     */
    public I2C getI2C(final int address) {
        if (i2cComponents.get(address) == null && address <= I2C_PORTS) {
            I2C i = new I2C(this, address);
            i2cComponents.put(address, i);
            return i;
        } else {
            throw new IllegalArgumentException("I2C address " + address + " is already taken!");
        }

    }

    @Override
    public int getModuleNumber() {
        return m_moduleNumber;
    }

    void setRelayForward(int m_channel, boolean b) {
    }

    void setRelayReverse(int m_channel, boolean b) {
    }

    boolean getRelayForward(int m_channel) {
        return false;
    }

    boolean getRelayReverse(int m_channel) {
        return false;
    }

    void setPWM(int m_channel, int kPwmDisabled) {
    }

    int getPWM(int m_channel) {
        return 0;
    }

    void setPWMPeriodScale(int m_channel, int i) {
    }
}
