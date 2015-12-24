package org.usfirst.frc2084.robotsimulator.wpilibj.networktables;

import org.usfirst.frc2084.robotsimulator.wpilibj.tables.ITableProvider;
import org.usfirst.frc2084.robotsimulator.wpilibj.tables.ITable;
import org.usfirst.frc2084.robotsimulator.wpilibj.networktables2.NetworkTableNode;
import java.util.*;


/**
 * Provides a {@link NetworkTable} for a given {@link NetworkTableNode}
 * 
 * @author Mitchell
 *
 */
public class NetworkTableProvider implements ITableProvider{
	private final NetworkTableNode node;
	private final Hashtable tables = new Hashtable();

	/**
	 * Create a new NetworkTableProvider for a given NetworkTableNode
	 * @param node the node that handles the actual network table 
	 */
	public NetworkTableProvider(NetworkTableNode node){
		this.node = node;
	}
	
	public ITable getRootTable(){
		return getTable("");
	}

	public ITable getTable(String key) {
		if (tables.containsKey(key)) {
			return (NetworkTable) tables.get(key);
		} else {
			NetworkTable table = new NetworkTable(key, this);
			tables.put(key, table);
			return table;
		}
	}

	/**
	 * @return the Network Table node that backs the Tables returned by this provider
	 */
	public NetworkTableNode getNode() {
		return node;
	}

	/**
	 * close the backing network table node
	 */
	public void close() {
		node.close();
	}
}
