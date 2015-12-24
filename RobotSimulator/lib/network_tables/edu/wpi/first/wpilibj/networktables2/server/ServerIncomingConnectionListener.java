package org.usfirst.frc2084.robotsimulator.library.networktables2.server;



/**
 * Listener for new incoming server connections
 * @author Mitchell
 *
 */
public interface ServerIncomingConnectionListener {
	/**
	 * 
	 * Called on create of a new connection
	 * @param connectionAdapter the server connection adapter
	 */
	void onNewConnection(ServerConnectionAdapter connectionAdapter);
}
