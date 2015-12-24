/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.library;

import org.usfirst.frc2084.robotsimulator.library.communication.UsageReporting;
import org.usfirst.frc2084.robotsimulator.library.livewindow.LiveWindowSendable;
import org.usfirst.frc2084.robotsimulator.library.parsing.IInputOutput;
import org.usfirst.frc2084.robotsimulator.library.tables.ITable;
import org.usfirst.frc2084.robotsimulator.library.util.AllocationException;
import org.usfirst.frc2084.robotsimulator.library.util.CheckedAllocationException;
import org.usfirst.frc2084.robotsimulator.virtualrobot.elements.Component;
import org.usfirst.frc2084.robotsimulator.virtualrobot.elements.DigitalInputComponent;
import org.usfirst.frc2084.robotsimulator.virtualrobot.elements.Displayable;

/**
 * Class to read a digital input. This class will read digital inputs and return
 * the current value on the channel. Other devices such as encoders, gear tooth
 * sensors, etc. that are implemented elsewhere will automatically allocate
 * digital inputs and outputs as required. This class is only for devices like
 * switches etc. that aren't implemented anywhere else.
 */
public class DigitalInput extends DigitalSource implements IInputOutput, LiveWindowSendable, Displayable {

    private int m_channel;
    private DigitalModule m_module;

    /**
     * Create an instance of a DigitalInput. Creates a digital input given a
     * digital module number and channel. Common creation routine for all
     * constructors.
     */
    private void initDigitalInput(int moduleNumber, int channel) {
        checkDigitalChannel(channel);
        checkDigitalModule(moduleNumber);
        m_channel = channel;
        m_module = DigitalModule.getInstance(moduleNumber);
        m_module.allocateDIO(channel, true);
        UsageReporting.report(UsageReporting.kResourceType_DigitalInput, channel, moduleNumber - 1);
    }

    /**
     * Create an instance of a Digital Input class. Creates a digital input
     * given a channel and uses the default module.
     *
     * @param channel the port for the digital input
     */
    public DigitalInput(int channel) {
        initDigitalInput(getDefaultDigitalModule(), channel);
    }

    /**
     * Create an instance of a Digital Input class. Creates a digital input
     * given an channel and module.
     *
     * @param moduleNumber The number of the digital module to use for this
     * input
     * @param channel the port for the digital input
     */
    public DigitalInput(int moduleNumber, int channel) {
        initDigitalInput(moduleNumber, channel);
    }

    public void free() {
        m_module.freeDIO(m_channel);
    }

    /**
     * Get the value from a digital input channel. Retrieve the value of a
     * single digital input channel from the FPGA.
     *
     * @return the stats of the digital input
     */
    public boolean get() {
        boolean state = m_module.getDIO(m_channel);
        if (state) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the channel of the digital input
     *
     * @return The GPIO channel number that this object represents.
     */
    public int getChannel() {
        return m_channel;
    }

    @Override
    public int getChannelForRouting() {
        return DigitalModule.remapDigitalChannel(getChannel() - 1);
    }

    @Override
    public int getModuleForRouting() {
        return m_module.getModuleNumber() - 1;
    }

    @Override
    public boolean getAnalogTriggerForRouting() {
        return false;
    }

    /**
     * Request interrupts asynchronously on this digital input.
     *
     * @param handler The address of the interrupt handler function of type
     * tInterruptHandler that will be called whenever there is an interrupt on
     * the digitial input port. Request interrupts in synchronus mode where the
     * user program interrupt handler will be called when an interrupt occurs.
     * The default is interrupt on rising edges only.
     * @param param argument to pass to the handler
     */
    public void requestInterrupts(/*tInterruptHandler*/Object handler, Object param) {
        //TODO: add interrupt support

        try {
            m_interruptIndex = interrupts.allocate();
        } catch (CheckedAllocationException e) {
            throw new AllocationException("No interrupts are left to be allocated");
        }

        allocateInterrupts(false);

//        m_interrupt.writeConfig_WaitForAck(false);
//        m_interrupt.writeConfig_Source_AnalogTrigger(getAnalogTriggerForRouting());
//        m_interrupt.writeConfig_Source_Channel((byte) getChannelForRouting());
//        m_interrupt.writeConfig_Source_Module((byte) getModuleForRouting());
        setUpSourceEdge(true, false);

        //TODO: m_manager.registerHandler(handler, param);
    }

    /**
     * Request interrupts synchronously on this digital input. Request
     * interrupts in synchronus mode where the user program will have to
     * explicitly wait for the interrupt to occur. The default is interrupt on
     * rising edges only.
     */
    public void requestInterrupts() {
        try {
            m_interruptIndex = interrupts.allocate();
        } catch (CheckedAllocationException e) {
            throw new AllocationException("No interrupts are left to be allocated");
        }

//        allocateInterrupts(true);

//        m_interrupt.writeConfig_Source_AnalogTrigger(getAnalogTriggerForRouting());
//        m_interrupt.writeConfig_Source_Channel((byte) getChannelForRouting());
//        m_interrupt.writeConfig_Source_Module((byte) getModuleForRouting());
        setUpSourceEdge(true, false);
    }

    /**
     * Set which edge to trigger interrupts on
     *
     * @param risingEdge true to interrupt on rising edge
     * @param fallingEdge true to interrupt on falling edge
     */
    public void setUpSourceEdge(boolean risingEdge, boolean fallingEdge) {
//        if (m_interrupt != null) {
//            m_interrupt.writeConfig_RisingEdge(risingEdge);
//            m_interrupt.writeConfig_FallingEdge(fallingEdge);
//        }
    }

    /*
     * Live Window code, only does anything if live window is activated.
     */
    @Override
    public String getSmartDashboardType() {
        return "Digital Input";
    }
    private ITable m_table;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initTable(ITable subtable) {
        m_table = subtable;
        updateTable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTable() {
        if (m_table != null) {
            m_table.putBoolean("Value", get());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ITable getTable() {
        return m_table;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startLiveWindowMode() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopLiveWindowMode() {
    }

    @Override
    public <T> Class<T extends Component<>> getComponent() {
        return DigitalInputComponent.class;
    }
}
