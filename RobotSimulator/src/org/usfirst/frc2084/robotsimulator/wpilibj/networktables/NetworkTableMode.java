package org.usfirst.frc2084.robotsimulator.wpilibj.networktables;

import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.thread.NTThreadManager;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.stream.IOStreamProvider;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.stream.IOStreamFactory;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.stream.SocketStreams;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.server.NetworkTableServer;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.client.NetworkTableClient;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.NetworkTableNode;
import java.io.*;

import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.type.NetworkTableEntryTypeManager;

/**
 * 
 * Represents a different modes that network tables can be configured in
 * 
 * @author Mitchell
 *
 */
public abstract class NetworkTableMode {

	/**
	 * A mode where Network tables will be a server on the specified port
	 */
	public static final NetworkTableMode Server = new NetworkTableMode("Server"){
		public NetworkTableNode createNode(String ipAddress, int port, NTThreadManager threadManager) throws IOException {
			IOStreamProvider streamProvider = SocketStreams.newStreamProvider(port);
			return new NetworkTableServer(streamProvider, new NetworkTableEntryTypeManager(), threadManager);
		}
	};
	/**
	 * A mode where network tables will be a client which connects to the specified host and port
	 */
	public static final NetworkTableMode Client = new NetworkTableMode("Client"){
		public NetworkTableNode createNode(String ipAddress, int port, NTThreadManager threadManager) throws IOException {
			if(ipAddress==null)
				throw new IllegalArgumentException("IP address cannot be null when in client mode");
			IOStreamFactory streamFactory = SocketStreams.newStreamFactory(ipAddress, port);
			NetworkTableClient client = new NetworkTableClient(streamFactory, new NetworkTableEntryTypeManager(), threadManager);
			client.reconnect();
			return client;
		}
	};
	private String name;
	private NetworkTableMode(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
	
	/**
	 * @param ipAddress the IP address configured by the user
	 * @param port the port configured by the user
	 * @param threadManager the thread manager that should be used for threads in the node
	 * @return a new node that can back a network table
	 * @throws IOException
	 */
	abstract NetworkTableNode createNode(String ipAddress, int port, NTThreadManager threadManager) throws IOException;
}
