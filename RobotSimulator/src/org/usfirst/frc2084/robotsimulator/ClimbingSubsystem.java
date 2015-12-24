/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator;

/**
 *
 * @author Ben
 */
public class ClimbingSubsystem {

    public double topPot;
    public double bottomPot = 221;
    private ClimbStage climbStage;

    public double getTopPotDegrees() {
        return topPot;

    }

    public double getBottomPotDegrees() {
        return bottomPot;
    }

    public enum ClimbStage {

        BEFORE_CONNECTION(1),
        FIRST_CLIMB(2),
        FIRST_TRANSFER(3),
        SECOND_CLIMB(4),
        SECOND_TRANSFER(5),
        LAST_LIFT(6);

        private ClimbStage(int i) {
            this.i = i;
        }
        private int i;

        public int getValue() {
            return i;
        }

        public static ClimbStage fromInt(int i) {
            for (ClimbStage cs : values()) {
                if (cs.i == i) {
                    return cs;
                }
            }
            return null;
        }
    }

    public ClimbStage getClimbStage() {
        return climbStage;
    }

    public void setClimbStage(ClimbStage climbStage) {
        this.climbStage = climbStage;
    }
    
}
