/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.virtualrobot.elements;

import org.usfirst.frc2084.robotsimulator.library.DigitalInput;
import javax.swing.JTextField;

/**
 *
 * @author Ben
 */
public class DigitalInputComponent extends Component<DigitalSidecar, DigitalInput> {

private JTextField field;

    public DigitalInputComponent(int port, DigitalSidecar module, DigitalInput disp) {
        super(port, module, , disp);
    }

    @Override
    public void update() {
    }
    
}
