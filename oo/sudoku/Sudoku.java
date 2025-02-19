package sudoku;
/**
 * Sudoku.java
 * 
 * Program for playing Sudoku.
 * 
 * @author Thomas VanDrunen
 * CS 245, Wheaton College, Fall 2007
 * In-class example
 * Sept 17, 2007
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Sudoku {

    public static void main(String[] args) {

        JFrame window = new JFrame();   // the main window
        window.setLocation(100, 100);
        window.setSize(600, 550);
        window.setTitle("Sudoku");
        window.setLayout(new GridLayout(4, 4));
        window.add(new JPanel());

        // object to "pass along" action events
        ActionEventPropagator propagator = new ActionEventPropagator();
        
        // Array of all entries in the Sudoku table. 
        // Entries are put in the array from left to right, top to bottom.
        // For example, the upper left square in the table corresponds to
        // indices 0, 1, 2, 9, 10, 11, 18, 19, 20 in the array.
        Entry[] allEntries = readEntriesFromFile(args, propagator);
        
        addColumnIndicators(window, allEntries, propagator);
        addSquares(window, allEntries, propagator);

        propagator.actionPerformed(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
 
    }

    // nitty gritty details below......

    private static Entry[] readEntriesFromFile(String[] args,
                                             ActionEventPropagator propagator) {
        Entry[] allEntries = new Entry[81];
        try {
            Scanner file = new Scanner(new FileInputStream(args[0]));
            for (int i = 0; i < allEntries.length; i++) {
                String nextEntry = file.nextLine();
                if (nextEntry.equals("."))
                    allEntries[i] = new OpenEntry(propagator);
                
                else 
                    allEntries[i] = new GivenEntry(nextEntry);
                                  
            }
            file.close();
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Please indicate the file containing the Sudoku problem.");
            System.exit(0);
        } catch (IOException ioe) {
            System.out.println("Error reading file " + args[0]);
            System.exit(0);
        }
        return allEntries;
    }

    private static void addColumnIndicators(JFrame window, Entry[] allEntries,
                                            ActionEventPropagator propagator) {
        for (int i = 0; i < 9; i+= 3) {
            JPanel panel = new JPanel();
            panel.setAlignmentY(Container.TOP_ALIGNMENT);
            panel.setLayout(new GridLayout(1,6));
            panel.add(new JPanel());
            for (int j = 0; j < 3; j++) {
                Entry[] currentEntries = new Entry[9];
                for (int k = 0; k < currentEntries.length; k++)
                    currentEntries[k] = allEntries[(i + j) + (k * 9)];
                RowColumn column = new RowColumn(currentEntries);
                propagator.addListener(column);
                panel.add(column.getButton());
                //panel.add(new JLabel());
            }
            JPanel panel2 = new JPanel();
            panel2.setLayout(new BorderLayout());
            panel2.add(panel, BorderLayout.SOUTH);
            window.add(panel2);
        }
    }

    private static void addSquares(JFrame window, Entry[] allEntries,
                                   ActionEventPropagator propagator) {
        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4,1));
            for (int j = 0; j < 3; j++) {
                Entry[] currentEntries = new Entry[9];
                for (int k = 0; k < currentEntries.length; k++)
                    currentEntries[k] = allEntries[k + ((i * 27) + (j * 9))];
                RowColumn row = new RowColumn(currentEntries);
                propagator.addListener(row);
                panel.add(row.getButton());
            }
            JPanel panel2 = new JPanel();
            panel2.setLayout(new BorderLayout());
            panel2.add(panel, BorderLayout.EAST);
            window.add(panel2);

            for (int j = 0; j < 3; j++) {
                Entry[] currentEntries = new Entry[9];
                int k = 0;
                for (int m = 0; m < 3; m++) {
                    currentEntries[k] = allEntries[(i * 27) + (j * 3) + m];
                    k++;
                }
                for (int m = 9; m < 12; m++) {
                    currentEntries[k] = allEntries[(i * 27) + (j * 3) + m];
                    k++;
                }
                for (int m = 18; m < 21; m++) {
                    currentEntries[k] = allEntries[(i * 27) + (j * 3) + m];
                    k++;
                }
                Square sqr = new Square(currentEntries);
                propagator.addListener(sqr);
                window.add(sqr.getPanel());
            }
        }
    }
}
