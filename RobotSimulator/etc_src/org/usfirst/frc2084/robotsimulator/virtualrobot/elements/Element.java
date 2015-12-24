/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Ben
 */
public abstract class Element extends JPanel {

    public Element(String label) {
        this.label = label;
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), label));
    }

    protected String label;

    public String getLabel() {
        return label;
    }
}
