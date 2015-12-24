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

/**
 * Class to read a digital input.
 * This class will read digital inputs and return the current value on the channel. Other devices
 * such as encoders, gear tooth sensors, etc. that are implemented elsewhere will automatically
 * allocate digital inputs and outputs as required. This class is only for devices like switches
 * etc. that aren't implemented anywhere else.
 */
public class DigitalInput extends DigitalSource implements IInputOutput, LiveWindowSendable{

    private int m_channel;
    private DigitalModule m_module;

    /**
     * Create an instance of a DigitalInput.
     * Creates a digital input given a digital module number and channel. Common creation routine
     * for all constructors.
     */
    private void initDigitalInput(int moduleNumber, int channel) {
        m_channel = channel;
        m_module = (DigitalModule) cRIO.getInstance().get(moduleNumber);
        UsageReporting.report(UsageReporting.kResourceType_DigitalInput, channel, moduleNumber-1);
    }

    /**
     * Create an instance of a Digital Input class.
     * Creates a digital input given a channel and uses the default module.
     * @param channel the port for the digital input
     */
    public DigitalInput(int channel) {
        initDigitalInput(1, channel);
    }

    /**
     * Create an instance of a Digital Input class.
     * Creates a digital input given an channel and module.
     * @param moduleNumber The number of the digital module to use for this input 
     * @param channel the port for the digital input
     */
    public DigitalInput(int moduleNumber, int channel) {
        initDigitalInput(moduleNumber, channel);
    }

    /**
     * Get the channel of the digital input
     * @return The GPIO channel number that this object represents.
     */
    public int getChannel() {
        return m_channel;
    }

    /*
     * Live Window code, only does anything if live window is activated.
     */
    public String getSmartDashboardType(){
        return "Digital Input";
    }
    private ITable m_table;
    
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
    public void updateTable() {
    }
    
    /**
     * {@inheritDoc}
     */
    public ITable getTable(){
        return m_table;
    }
    
    /**
     * {@inheritDoc}
     */
    public void startLiveWindowMode() {}
    
    /**
     * {@inheritDoc}
     */
    public void stopLiveWindowMode() {}

    @Override
    public int getChannelForRouting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getModuleForRouting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getAnalogTriggerForRouting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean get() {
        return false; // need to change this
    }

}
