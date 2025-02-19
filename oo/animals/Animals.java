package animals;
/**
 * Animals.java
 * 
 * This program plays the "animals" game, where the user is
 * asked a series of questions until the program can guess an
 * animal that the user is thinking of. If the guess is wrong,
 * the program learns a new animal, adding it to its knowledge base.
 * 
 * The file format is 
 * <Node> ::= <Question> | <Animal>
 * <Question> ::= Q
 *                <string>
 *                <Node>
 *                <Node>
 * <Animal> ::= A
 *              <string>
 * 
 * @author Thomas VanDrunen
 * Wheaton College, CS 241, Spring 2005
 * In-class example
 * Apr 27, 2005
 */
import java.io.*;
import java.util.*;

public class Animals {

    /**
     * For user input from the keyboard.
     */
    public static Scanner keyboard;

    public static void main(String[] args) {
        keyboard = new Scanner(System.in);

        Node top;    // The top of the tree, the first question to be asked.

        // Attempt to read in saved animal knowledge from a file,
        // but if that fails, make a default knowledge base with two animals
        try {
            Scanner file =     // used to read in from a file
                new Scanner(new FileInputStream("animals.dat"));
            file.nextLine();   // get rid of initial "Q"
            top = new Question(file);
            file.close();
        } catch (IOException ioe) {
            top = new Question("Does it live in water?",
                               new Animal("alligator"), 
                               new Animal("giraffe"));
        } 

        // The number of animals in the knowledge base
        int numAnimals = top.numberOfAnimals();

        System.out.println("I know " + numAnimals + " animals.");

        // Repeatedly go through the questions until the user
        // indicates the game should end.
        do {
            top = top.ask();
            
            // Comment if the number of animals has changed.
            if (numAnimals != top.numberOfAnimals()) {
                numAnimals = top.numberOfAnimals();
                System.out.println("Now I know " + numAnimals + " animals.");
            }
            System.out.print("Do you want to play again?");
        } while (keyboard.nextLine().equals("y"));

        try {
            PrintWriter pw =         // used to write to a file
                new PrintWriter(new FileOutputStream("animals.dat"));
            top.print(pw);
            pw.close();
        } catch (IOException ioe) {
            System.out.println("Could not save animal knowledge.");
        }
    }
}
