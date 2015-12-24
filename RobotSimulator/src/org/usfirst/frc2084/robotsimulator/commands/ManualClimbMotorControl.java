/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator.commands;

import org.usfirst.frc2084.robotsimulator.Robot;
import static org.usfirst.frc2084.robotsimulator.Robot.climbingSubsystem;
import org.usfirst.frc2084.robotsimulator.wpilibj.SmartDashboard;
import org.usfirst.frc2084.robotsimulator.wpilibj.command.Command;

/**
 *
 * @author Ben
 */
public class ManualClimbMotorControl extends Command {

    private static final double // Arm software stop constants
            TOP_HIGH_LIMIT = 300, // Need real value
            TOP_LOW_LIMIT = 0, // Need real value
            BOTTOM_HIGH_LIMIT = 300, // Need real value
            BOTTOM_LOW_LIMIT = 0, // Need real value
            // Acceleration filter constants
            SAFETY_TIME_THRESHHOLD = 0.3, // See below
            SAFETY_INCREASE_LIMIT = 0.3, // Maximium the speed can increase every SAFETY_TIME_THRESHHOLD seconds
            SAFETY_RESET_THRESHOLD = 0.1; // The threshold at which the safety resets

    @Override
    protected void initialize() {
    }
    private long lastTime = System.nanoTime();
    private static final int DEGREES_PER_SECOND = 30;
    private double lastLeftValue;
    private double lastRightValue;
    private boolean topSafetyTriggered;
    private boolean bottomSafetyTriggered;

    @Override
    protected void execute() {
        System.out.println("asdf");
        double leftJoy = Robot.oi.getLeftJoystick().getY();
        double rightJoy = Robot.oi.getRightJoystick().getY();

        long timeElapsed = System.nanoTime() - lastTime;
        lastTime = System.nanoTime();


        //System.out.println(newTopPot);



        double topSpeed = leftJoy;
        double bottomSpeed = rightJoy;
        double topPot = Robot.climbingSubsystem.getTopPotDegrees();
        double bottomPot = Robot.climbingSubsystem.getBottomPotDegrees();
        long currTime = System.nanoTime();
//        Add code to control arm here (commented out for now with no pots)
        if ((topPot < TOP_LOW_LIMIT && leftJoy < 0) || (topPot > TOP_HIGH_LIMIT && leftJoy > 0)) {
            topSpeed = 0;
        }
        if ((bottomPot < BOTTOM_LOW_LIMIT && rightJoy < 0) || (bottomPot > BOTTOM_HIGH_LIMIT && rightJoy > 0)) {
            bottomSpeed = 0;
        }
        boolean justTriggeredTop = false;
        boolean justTriggeredBottom = false;
        if (currTime - lastTime > SAFETY_TIME_THRESHHOLD) {
            if (Math.abs(rightJoy) > Math.abs(lastRightValue) + SAFETY_INCREASE_LIMIT) {
                bottomSpeed = 0;
                bottomSafetyTriggered = true;
                justTriggeredBottom = true;
            }
            if (Math.abs(leftJoy) > Math.abs(lastLeftValue) + SAFETY_INCREASE_LIMIT) {
                topSpeed = 0;
                topSafetyTriggered = true;
                justTriggeredTop = true;
            }
            lastLeftValue = leftJoy;
            lastRightValue = rightJoy;
            lastTime = currTime;
        }
        if (topSafetyTriggered && !justTriggeredTop) {
            if (Math.abs(leftJoy) >= SAFETY_RESET_THRESHOLD) {
                topSpeed = 0;
            } else {
                topSafetyTriggered = false;
            }
        }
        if (bottomSafetyTriggered && !justTriggeredBottom) {
            if (Math.abs(rightJoy) >= SAFETY_RESET_THRESHOLD) {
                bottomSpeed = 0;
            } else {
                bottomSafetyTriggered = false;
            }
        }
        climbingSubsystem.topPot += (timeElapsed / 1_000_000_000.0 * (DEGREES_PER_SECOND * topSpeed));
        climbingSubsystem.bottomPot += (timeElapsed / 1_000_000_000.0 * (DEGREES_PER_SECOND * bottomSpeed));
//        SmartDashboard.putData(Robot.robotViewer);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
