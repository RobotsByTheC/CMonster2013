package org.usfirst.frc2084.robotsimulator.library.networktables2.type;

import org.usfirst.frc2084.robotsimulator.library.networktables2.util.*;

public class NetworkTableEntryTypeManager {
	private final ByteArrayMap typeMap = new ByteArrayMap();
	
	public NetworkTableEntryType getType(byte id){
		return (NetworkTableEntryType)typeMap.get(id);
	}
	
	void registerType(NetworkTableEntryType type){
		typeMap.put(type.id, type);
	}
	
	public NetworkTableEntryTypeManager(){
		DefaultEntryTypes.registerTypes(this);
	}
}
