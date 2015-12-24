/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.smartdashboard.camera;

import edu.wpi.first.smartdashboard.camera.WPICameraExtension;
import edu.wpi.first.smartdashboard.properties.StringProperty;

/**
 *
 * @author Ben Wolsieffer
 */
public class Camera2084Extension extends WPICameraExtension {

    public static final String NAME = "2084 Camera";
    private StringProperty usernameProperty = new StringProperty(this, "Username");
    private StringProperty passwordProperty = new StringProperty(this, "Password");

    public Camera2084Extension() {
    }
    
}
