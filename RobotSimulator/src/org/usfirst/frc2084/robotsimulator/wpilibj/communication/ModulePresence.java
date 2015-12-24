/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc2084.robotsimulator.wpilibj.communication;

import org.usfirst.frc2084.robotsimulator.hardware.crio.cRIO;

/**
 * Class for communicating with the NetworkCommunication library routines which
 * check module presence.
 *
 * @author pmalmsten
 */
public class ModulePresence {

    public static final int kMaxModuleNumber = 2;

    public static class ModuleType {

        public static final ModuleType kUnknown = new ModuleType(0x00);
        public static final ModuleType kAnalog = new ModuleType(0x01);
        public static final ModuleType kDigital = new ModuleType(0x02);
        public static final ModuleType kSolenoid = new ModuleType(0x03);
        private final int m_intValue;

        private ModuleType(int value) {
            m_intValue = value;
        }

        public int getValue() {
            return m_intValue;
        }
    };

    /**
     * Determines whether the module of the given type and number is present.
     *
     * @param moduleType The type of the module to be checked.
     * @param moduleNumber The ID for this type of module to check (should be 0
     * or 1).
     * @return Whether the given module is present.
     */
    public static boolean getModulePresence(ModuleType moduleType, int moduleNumber) {
        return cRIO.getInstance().get(moduleType.getValue() + 4 * moduleNumber) != null;
    }
}
