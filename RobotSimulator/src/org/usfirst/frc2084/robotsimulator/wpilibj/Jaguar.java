/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.wpilibj;

/**
 *
 * @author Ben
 */
public class Jaguar extends SafePWM implements SpeedController {

    private int module;
    private int port;
    private double power;

    public Jaguar(int module, int port) {
        super(module, port);
        this.module = module;
        this.port = port;
//        ((DigitalModule) cRIO.getInstance().get(module)).add(this);
    }
    
    public Jaguar(int port) {
        super(port);
    }

    @Override
    public void set(double power) {
        this.power = power;
    }

    @Override
    public double get() {
        return power;
    }

    @Override
    public void set(double speed, byte syncGroup) {
        set(speed);
    }

    @Override
    public void pidWrite(double output) {
        set(output);
    }
}
