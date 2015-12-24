package org.usfirst.frc2084.robotsimulator.wpilibj.networktables2;



public interface FlushableOutgoingEntryReceiver extends OutgoingEntryReceiver{
	public void flush();

	public void ensureAlive();
}
