/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.CMonster;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2084.CMonster.subsystems.ClimbingSubsystem;

/**
 *
 * @author Ben Wolsieffer
 */
public class RobotViewer implements NamedSendable {

    private ITable table;
    private static final String NAME = "Robot Viewer";
    
    public void initTable(ITable subtable) {
        table = subtable;
        updateTable();
    }

    public String getName() {
        return NAME;
    }

    private void updateTable() {
        table.putNumber("topAngle", Robot.climbingSubsystem.getTopPotDegrees());
        table.putNumber("bottomAngle", Robot.climbingSubsystem.getBottomPotDegrees());
        table.putNumber("topPower", RobotMap.climbingSubsystemTopJaguar.get());
        table.putNumber("bottomPower", RobotMap.climbingSubsystemBottomJaguar.get());
        Robot.climbingSubsystem.setClimbStage(ClimbingSubsystem.ClimbStage.fromInt((int)table.getNumber("climbStage", -1)));
    }

    public ITable getTable() {
        return table;
    }

    public String getSmartDashboardType() {
        return "Robot Viewer";
    }
}
