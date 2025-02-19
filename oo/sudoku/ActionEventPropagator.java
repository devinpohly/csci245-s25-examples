package sudoku;
/**
 * ActionEventPropagator.java
 * 
 * Class to "pass on the news" that an action event has happened.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Fall 2007
 * In-class example
 * Sept 17, 2007
 */

import java.awt.event.*;
import java.util.*;

public class ActionEventPropagator implements ActionListener {

    /**
     * The listeners listening to this listener.
     */
    private HashSet<ActionListener> listeners;

    /**
     * Constructor. Simply makes an appropriate HashSet.
     */
    public ActionEventPropagator() {
        listeners = new HashSet<ActionListener>();
    }

    /**
     * Add a listener to this propagator.
     * POSTCONDITION: We have one more listener added to our
     * list of listeners (if the new one wasn't there already).
     * @param listener The listener to add.
     */
    public void addListener(ActionListener listener) {
        listeners.add(listener);
    }

    /**
     * Pass along the action performed.
     * Iterate through the listeners, calling all of their actionPerformed()
     * methods.
     * @param ae Passed along to the listeners.
     */
    public void actionPerformed(ActionEvent ae) {
        for (Iterator<ActionListener> it = listeners.iterator(); it.hasNext(); )
            it.next().actionPerformed(ae);
    }

}
