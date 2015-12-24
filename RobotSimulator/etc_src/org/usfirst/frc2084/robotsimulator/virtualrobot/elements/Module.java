/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

import java.awt.GridLayout;
import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public abstract class Module extends Element {

    protected ArrayList<Component> components = new ArrayList<>();


    public Module(String label) {
        this.label = label;
        setLayout(new GridLayout(0, 1));
    }

    public void addComponent(Component component) {
        components.add(component);
        add(component);
    }
    
    public boolean supportsSubModule(SubModule sm){
        return false;
    }
}
