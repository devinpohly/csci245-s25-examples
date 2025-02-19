package sudoku;
/**
 * OpenEntry.java
 * 
 * Class to model an entry in the table that
 * the player can select.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Fall 2007
 * In-class example
 * Sept 17, 2007
 */

import java.awt.event.*;
import java.awt.Component;
import javax.swing.JComboBox;

public class OpenEntry implements Entry, ActionListener {

    /**
     * The options for the JComboBoxes. Since this will
     * be the same for all OpenEntries, we keep only one of these to share.
     */
    private static String[] options = 
         { "", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    /**
     * The current value of this entry in the Sudoku table
     */
    private String value;

    /**
     * The drop-list of possible entries
     */
    private JComboBox<String> box;

    /**
     * The object which will propagate an action event to the other
     * listeners.
     */
    private ActionEventPropagator propagator;
    
    /**
     * Constructor. Set the value initially to unknown
     * @param propagator The object to propagate action events.
     */
    public OpenEntry(ActionEventPropagator propagator) {
        value = "";
        box = new JComboBox<String>(options);
        box.addActionListener(this);
        this.propagator = propagator;
    }

    /**
     * Retrieve the value of this entry, empty string for unknown.
     * This is stored in the instance variable value.
     * @return The value (empty string for unknown)
     */
    public String value() { return value; }
    
    /**
     * Return the GUI component to represent this entry.
     * The gui component is the box we have stored here,
     * so this is an accessor method.
     * @return the JComboBox.
     */
    public Component display() {
        return box;
    }

    /**
     * React to the user selecting a new item.
     * Change the value to whatever was selected, and tell the
     * propagator about this event.
     * POSTCONDITION: The value stored here has been updated
     * @param ae Unused.
     */
    public void actionPerformed(ActionEvent ae) {
        value = (String) box.getSelectedItem();
        propagator.actionPerformed(ae);
    }

}


