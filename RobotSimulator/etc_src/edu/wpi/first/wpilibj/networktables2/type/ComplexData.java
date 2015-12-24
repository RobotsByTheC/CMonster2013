package org.usfirst.frc2084.robotsimulator.library.networktables2.type;

/**
 *
 * @author Mitchell
 */
public class ComplexData {
    private final ComplexEntryType type;
    public ComplexData(ComplexEntryType type){
        this.type = type;
    }
    
    public ComplexEntryType getType() {
        return type;
    }
}
