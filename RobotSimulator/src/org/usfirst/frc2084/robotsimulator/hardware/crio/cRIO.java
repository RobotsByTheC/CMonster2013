/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.hardware.crio;

import org.usfirst.frc2084.robotsimulator.wpilibj.AnalogModule;
import org.usfirst.frc2084.robotsimulator.wpilibj.DigitalModule;
import org.usfirst.frc2084.robotsimulator.wpilibj.Module;

/**
 *
 * @author Ben Wolsieffer
 */
public final class cRIO {

    private static Type TYPE = Type.II;
    private final int numModules;
    private static cRIO instance;
    private static Module[] modules; // No need to use a HashMap, its just unnecessarily slow

    public enum Type {

        I, II;
    }

    /**
     * Gets a singleton instance of the cRIO.
     *
     * @return the cRIO
     */
    public static cRIO getInstance() {
        if (instance == null) {
            instance = new cRIO(TYPE);
        }
        return instance;
    }

    public static void setType(Type type) {
        if (instance == null) {
            TYPE = type;
        } else {
            throw new IllegalStateException("cRIO already initialized");
        }
    }

    private cRIO(Type type) {
        switch (type) {
            case I:
                numModules = 8;
                break;
            case II:
                numModules = 4;
                break;
            default:
                numModules = 4;
        }
        modules = new Module[numModules];
    }

    public void add(DigitalModule module) {
        int slot = module.getModuleNumber();
        slot = digitalModuleToSlot(slot);
        if (modules[slot - 1] == null && slot < numModules) {
            modules[slot - 1] = module;
        } else {
            throw new IllegalArgumentException("cRIO slot " + slot + " is already in use or is not on the cRIO");
        }
    }

    public void add(AnalogModule module) {
        int slot = module.getModuleNumber();
        slot = analogModuleToSlot(slot);
        if (modules[slot - 1] == null && slot < numModules) {
            modules[slot - 1] = module;
        } else {
            throw new IllegalArgumentException("cRIO slot " + slot + " is already in use or is not on the cRIO");
        }
    }

    private int digitalModuleToSlot(int moduleNumber) {
        if (moduleNumber == 1) {
            moduleNumber = 2;
        } else if (moduleNumber == 2) {
            moduleNumber = 4;
        }
        return moduleNumber;
    }

    private int analogModuleToSlot(int moduleNumber) {
        if (moduleNumber == 1) {
            moduleNumber = 1;
        } else if (moduleNumber == 2) {
            moduleNumber = 4;
        }
        return moduleNumber;
    }

    public Module get(int slot) {
        return modules[slot - 1];
    }

    public DigitalModule getDigitalModule(int moduleNumber) {
        moduleNumber = digitalModuleToSlot(moduleNumber);
        Module m = get(moduleNumber);
        if (m instanceof DigitalModule) {
            return (DigitalModule) m;
        }
        throw new IllegalArgumentException("Digital module does not exist.");
    }
}
