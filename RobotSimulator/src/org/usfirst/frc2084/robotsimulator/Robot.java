/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.robotsimulator;

import org.usfirst.frc2084.robotsimulator.commands.TeleopBackground;
import org.usfirst.frc2084.robotsimulator.wpilibj.IterativeRobot;
import org.usfirst.frc2084.robotsimulator.wpilibj.command.Command;
import org.usfirst.frc2084.robotsimulator.wpilibj.command.Scheduler;

/**
 *
 * @author Ben
 */
public class Robot extends IterativeRobot {

    public static OI oi;
    private RobotViewer robotViewer;
    public static ClimbingSubsystem climbingSubsystem;
    Command autonomousCommand;

    public RobotViewer getRobotViewer() {
        return robotViewer;
    }

    @Override
    public void robotInit() {
        RobotMap.init();
        climbingSubsystem = new ClimbingSubsystem();
        oi = new OI();
        robotViewer = new RobotViewer();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        (new TeleopBackground()).start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
