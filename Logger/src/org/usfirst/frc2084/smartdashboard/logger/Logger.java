package org.usfirst.frc2084.smartdashboard.logger;

import edu.wpi.first.smartdashboard.gui.elements.LinePlot;
import edu.wpi.first.smartdashboard.properties.FileProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Ben Wolsieffer
 */
public class Logger extends LinePlot {

    private FileProperty logFileProperty = new FileProperty(this, "Log File");
    public static final String NAME = "Logger";
    private File logFile;
    private FileWriter logFileWriter;

    public Logger() {
        this.logFile = new File(logFileProperty.getSaveValue());
    }

    @Override
    public void setValue(double value) {
        super.setValue(value);
        try {
            if (logFileWriter == null) {
                logFileWriter = new FileWriter(logFile);
            }
            logFileWriter.write(Double.toString(value) + "\n");
        } catch (IOException ex) {
        }

    }

    @Override
    public void propertyChanged(Property property) {
        super.propertyChanged(property);
        if (property == logFileProperty) {
                logFile = new File(logFileProperty.getSaveValue());
        }
    }

    @Override
    public void disconnect() {
        try {
            logFileWriter.close();
        } catch (IOException ex) {
        }
        logFileWriter = null;
    }
}
