package sudoku;
/**
 * Entry.java
 * 
 * Supertype for entries in the Sudoku table.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Fall 2007
 * In-class example
 * Sept 17, 2007
 */

import java.awt.Component;

public interface Entry {
        
        /**
         * Retrieve the value of this entry (zero for unknown)         
         */
        public String value();
        
        /**
         * Return the GUI component to represent this entry.
         */
        public Component display();
}
