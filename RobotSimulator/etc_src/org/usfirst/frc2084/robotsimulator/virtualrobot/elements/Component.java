/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

/**
 *
 * @author Ben
 */
public abstract class Component<M extends Module, D extends Displayable> extends Element {

    protected M module;
    protected D disp;
    public Component(M module, String label, D disp) {
        super(label);
        this.module = module;
        this.disp = disp;
    }

    public M getModule(){
        return module;
    }

    public abstract void update();
}
