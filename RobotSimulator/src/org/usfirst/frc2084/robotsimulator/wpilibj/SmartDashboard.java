/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.wpilibj;


import org.usfirst.frc2084.robotsimulator.wpilibj.tables.ITable;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Ben
 */
public class SmartDashboard {

    private static final NetworkTable table = NetworkTable.getTable("SmartDashboard");

    public static void putData(String key, Sendable value) {
        ITable dataTable = table.getSubTable(key);
        dataTable.putString("~TYPE~", value.getSmartDashboardType());
        value.initTable(dataTable);
    }

    public static void putData(NamedSendable value) {
        putData(value.getName(), value);
    }
}
