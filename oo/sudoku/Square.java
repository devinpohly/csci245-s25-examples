package sudoku;
/**
 * Square.java
 * 
 * Class for modeling a square in the Sudoku table.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Fall 2007
 * In-class example
 * Sept 17, 2007
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Square implements ActionListener {

    /**
     * The entries constituting this row or column.
     */
    private Entry[] entries;

    /**
     * The panel showing the entries.
     */
    private JPanel panel;

    /**
     * The color of the panel before we mess with it.
     * We need to record this so we can switch it back.
     */
    private Color defaultColor;

    /**
     * Constructor.
     * Store the entries, create the panel, and record the default
     * color.
     * @param entries An array of entries for this square.
     */
    public Square(Entry[] entries) {
        this.entries = new Entry[9];
        panel = new JPanel();
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
            panel.add(entries[i].display());
        }
        defaultColor = panel.getBackground();
    }

    /**
     * Accessor method for the panel.
     * @return The panel showing the entries.
     */
    public Component getPanel() { return panel; }

    /**
     * Set the background color of this square to show if
     * there are violations, or if the square is complete.
     * Make a hashset that contains all the elements that should be
     * in a row or column. Iterate through the entries.
     * If there are any unknowns, take note. If it contains a value that
     * is not in the hashset, that means the value is in the row/column twice,
     * a violation. Otherwise, remove the value from the hashset.
     * Finally, change the color to red, green, or default, based on 
     * what we've found.
     * @param ae Unused
     */    
    public void actionPerformed(ActionEvent ae) {
        boolean unknowns = false;    // have we encountered any unknowns?
        boolean violation = false;     // Have we found a violation?
        
        // The set of things we should find in a complete row
        HashSet<String> values = new HashSet<String>();
        for (int i = 1; i < 10; i++)
            values.add(i + "");

        for (int i = 0; i < entries.length; i++) {

            // the value we've found in the current entry
            String value = entries[i].value(); 

            if (value.equals("")) 
                unknowns = true;
            else if (! values.contains(value)) 
                violation = true;
            else 
                values.remove(value);
        }
        if (violation) 
            panel.setBackground(Color.RED);
        else if (unknowns) 
            panel.setBackground(defaultColor);
        else 
            panel.setBackground(Color.GREEN);
    }

}
