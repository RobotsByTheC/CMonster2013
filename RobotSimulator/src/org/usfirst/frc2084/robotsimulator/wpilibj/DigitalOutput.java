/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.wpilibj;

import org.usfirst.frc2084.robotsimulator.hardware.crio.cRIO;
import org.usfirst.frc2084.robotsimulator.wpilibj.communication.UsageReporting;
import org.usfirst.frc2084.robotsimulator.wpilibj.livewindow.LiveWindowSendable;
import org.usfirst.frc2084.robotsimulator.wpilibj.parsing.IInputOutput;
import org.usfirst.frc2084.robotsimulator.wpilibj.tables.ITable;
import org.usfirst.frc2084.robotsimulator.wpilibj.tables.ITableListener;

/**
 * Class to write digital outputs. This class will write digital outputs. Other
 * devices that are implemented elsewhere will automatically allocate digital
 * inputs and outputs as required.
 */
public class DigitalOutput extends DigitalSource implements IInputOutput, LiveWindowSendable{

    private int m_channel;
    private DigitalModule m_module;
    private boolean isOn = false;

    private void initDigitalOutput(int moduleNumber, int channel) {
        m_channel = channel;
        m_module = (DigitalModule) cRIO.getInstance().get(moduleNumber);
//        m_module.add(this);
        UsageReporting.report(UsageReporting.kResourceType_DigitalOutput, channel, moduleNumber - 1);
    }

    /**
     * Create an instance of a digital output. Create an instance of a digital
     * output given a module number and channel.
     *
     * @param moduleNumber The number of the digital module to use
     * @param channel the port to use for the digital output
     */
    public DigitalOutput(int moduleNumber, int channel) {
        initDigitalOutput(moduleNumber, channel);
    }

    /**
     * Create an instance of a digital output. Create a digital output given a
     * channel. The default module is used.
     *
     * @param channel the port to use for the digital output
     */
    public DigitalOutput(int channel) {
        initDigitalOutput(1, channel);
    }

    /**
     * Set the value of a digital output.
     *
     * @param value true is on, off is false
     */
    public void set(boolean value) {
        isOn = value;
    }
    
    public boolean get() {
        return isOn;
    }

    /**
     * @return The GPIO channel number that this object represents.
     */
    public int getChannel() {
        return m_channel;
    }

    /**
     * @return The value to be written to the channel field of a routing mux.
     */
    public int getChannelForRouting() {
        return getChannel() - 16;
    }

    /**
     * @return The value to be written to the module field of a routing mux.
     */
    public int getModuleForRouting() {
        return m_module.getModuleNumber() - 1;
    }

    /**
     * @return The value to be written to the analog trigger field of a routing
     * mux.
     */
    public boolean getAnalogTriggerForRouting() {
        return false;
    }
    /*
     * Live Window code, only does anything if live window is activated.
     */

    public String getSmartDashboardType() {
        return "Digital Output";
    }
    private ITable m_table;
    private ITableListener m_table_listener;

    /**
     * {@inheritDoc}
     */
    public void initTable(ITable subtable) {
        m_table = subtable;
        updateTable();
    }

    /**
     * {@inheritDoc}
     */
    public ITable getTable() {
        return m_table;
    }

    /**
     * {@inheritDoc}
     */
    public void updateTable() {
        // TODO: Put current value.
    }

    /**
     * {@inheritDoc}
     */
    public void startLiveWindowMode() {
        m_table_listener = new ITableListener() {
            public void valueChanged(ITable itable, String key, Object value, boolean bln) {
                set(((Boolean) value).booleanValue());
            }
        };
        m_table.addTableListener("Value", m_table_listener, true);
    }

    /**
     * {@inheritDoc}
     */
    public void stopLiveWindowMode() {
        // TODO: Broken, should only remove the listener from "Value" only.
        m_table.removeTableListener(m_table_listener);
    }
}
