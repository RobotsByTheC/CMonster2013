/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2084.smartdashboard.camera;

import edu.wpi.first.smartdashboard.properties.PropertyHolder;
import edu.wpi.first.smartdashboard.properties.StringProperty;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Robot
 */
public class PasswordProperty extends StringProperty {

    private TableCellRenderer renderer = new TableCellRenderer() {
        JPasswordField field = new JPasswordField();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            field.setText((String) value);
            return field;
        }
    };

    public PasswordProperty(PropertyHolder element, String name) {
        super(element, name);
       
    }

    @Override
    public TableCellRenderer getRenderer() {
        return renderer;
    }

    public PasswordProperty(PropertyHolder element, String name, String defaultValue) {
        super(element, name, defaultValue);
    }
    
}
