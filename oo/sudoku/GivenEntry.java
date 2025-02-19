package sudoku;
/**
 * GivenEntry.java
 * 
 * Class to represent an entry in the Sudoku table
 * given at the beginning.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Spring 2007
 * In-class example
 * Sept 17, 2007
 */

import java.awt.*;
import javax.swing.JTextField;

public class GivenEntry implements Entry {

    /**
     * The value of this entry.
     */
    private String value;
    
    /**
     * Constructor; uses the given value.
     * @param value The hard-wired value.
     */
    public GivenEntry(String value) {
        this.value = value;
    }
    
    /**
     * Retrieve the value of this entry, empty string for unknown.
     * This is stored in the instance variable value.
     * @return The value (empty string for unknown)
     */
    public String value() { return value; }

    /**
     * Represent this entry with an uneditable textfield.
     * @return An uneditable textfield.
     */
    public Component display() { 
        // The textfield (it's size 3 so that it's the same width
        // as a JComboBox)
        JTextField toReturn = new JTextField(3);  
        toReturn.setText(value + "");
        toReturn.setEditable(false);
        return toReturn;
    }


}

