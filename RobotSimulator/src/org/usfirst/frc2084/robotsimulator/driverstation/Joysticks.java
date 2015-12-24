/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.driverstation;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.ControllerEvent;
import net.java.games.input.ControllerListener;
import org.usfirst.frc2084.robotsimulator.hardware.RobotControl;

/**
 *
 * @author Ben Wolsieffer
 */
public class Joysticks {

    private static Controller[] sticks = new Controller[4];
    private final static ControllerListener controllerListener = new ControllerListener() {
        @Override
        public void controllerRemoved(ControllerEvent ce) {
            refreshControllers();
        }

        @Override
        public void controllerAdded(ControllerEvent ce) {
            refreshControllers();
        }
    };

    static {
        ControllerEnvironment.getDefaultEnvironment().addControllerListener(controllerListener);
        refreshControllers();
    }

    private static void refreshControllers() {
        Controller[] cs = ControllerEnvironment.getDefaultEnvironment().getControllers();
        int ji = 0;
        for (int i = 0; ji < 4 && i < cs.length; i++) {
            if (cs[i].getType() != Controller.Type.STICK) {
                cs[i] = null;
                sticks[ji] = cs[i];
                ji++;
            }
        }
    }

    public static void updateControllers() {
        for (int j = 0; j < sticks.length; j++) {
            if (sticks[j] != null && sticks[j].poll()) {
                Component[] coms = sticks[j].getComponents();
                int axisIndex = 0, buttonIndex = 0;
                for (int i = 0; i < coms.length; i++) {
                    if (coms[i].isAnalog() && !coms[i].isRelative()) {
                        RobotControl.setStickAxis(j, axisIndex, coms[i].getPollData());
                        axisIndex++;
                    } else if (!coms[i].isAnalog() && !coms[i].isRelative()) {
                        RobotControl.setStickButton(j, buttonIndex, coms[i].getPollData() > 0 ? true : false);
                        buttonIndex++;
                    }
                }
            }
        }
    }
}
