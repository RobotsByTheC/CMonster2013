package org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.connection;

import java.io.*;

/**
 * An exception throw when a NetworkTableNode receives a bad message
 * 
 * @author Mitchell
 *
 */
public class BadMessageException extends IOException {
	/**
	 * Create a new exception
	 * @param message a message
	 */
	public BadMessageException(final String message) {
		super(message);
	}
}
