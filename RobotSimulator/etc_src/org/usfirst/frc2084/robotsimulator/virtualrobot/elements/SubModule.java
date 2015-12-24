/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

/**
 *
 * @author Ben
 */
public abstract class SubModule<M extends Module> extends Module {

    private M module;

    public SubModule(String label, M module) {
        super(label);
        this.module = module;
    }

    public M getModule() {
        return module;
    }
}
