package animals;
/**
 * Animal.java
 * 
 * A class to represent an animal known by this program. This
 * is a leaf in the knowledge tree.
 * 
 * @author Thomas VanDrunen
 * Wheaton College, CS 241, Spring 2005
 * In-class example
 * Apr 27, 2005
 */

import java.io.*;
import java.util.*;

public class Animal implements Node {

    /**
     * The name of the animal represented by this node.
     */
    private String animal;

    /**
     * Constructor, given the name of an animal
     * @param animal The name of the animal this node is for
     */
    public Animal(String animal) {
        this.animal = animal;
    }

    /**
     * Constructor, given a BufferedReader from which to read information.
     * The name of the animal should be on the next line of the file;
     * this expects the "A" indicating this is an animal has already been read.
     * @param br The buffered reader from which to read
     */
    public Animal(Scanner file) throws IOException {
        this.animal = file.nextLine();
    }

    /**
     * Recursively ask the user questions until an animal is guessed.
     * Ask the user if the animal represented here is the one thought of.
     * If so, return the current node, since nothing will change.
     * If not, ask the user for the correct animal (constructing a corresponding
     * Animal node) and a question to differentiate. Construct a new
     * Question node with the question, this, and the new animal, and
     * return that in place of this.
     * @return A node to stand in the place of this one, in case the tree 
     * has changed.
     */
    public Node ask() {
        System.out.println("Is the animal you are thinking of a(n) " +
                           animal + "?");
        String answer = Animals.keyboard.nextLine();     // Query from the user
        if (answer.equals("y") || answer.equals("Y") || answer.equals("yes")) {
            System.out.println("I got it!");
            return this;
        }
        else {
            System.out.println("Ok, what animal were you thinking of?");
            // The name of the new animal
            String newAnimal = Animals.keyboard.nextLine();
            // A node standing for the new animal
            Node newAnimalNode = new Animal(newAnimal);
            System.out.println("Please enter a question to "
                               + "differentiate between a(n) " + animal
                               + " and a(n) " + newAnimal + ".");
            // The new question to ask to differentiate
            String newQuestion = Animals.keyboard.nextLine();
            System.out.print("What would be the correct answer for a(n) "
                             + newAnimal + "?");
            // What query should we expect to indicate the new animal?
            String newAnswer = Animals.keyboard.nextLine();
            // A node standing for the new question
            Question newQuestionNode;
            if (newAnswer.equals("y") || newAnswer.equals("Y") || newAnswer.equals("yes"))
                newQuestionNode = new Question(newQuestion, newAnimalNode,
                                               this);
            else
                newQuestionNode = new Question(newQuestion, this, 
                                               newAnimalNode);
            return newQuestionNode;
        }
    }

    /**
     * Recursively write the tree rooted at this node to the given 
     * PrintWriter. The format is to write an "A" on one line to 
     * indicate this is an animal node, followed by the name on 
     * the next line.
     * @param pw The PrintWriter on which to write this output.
     */
    public void print(PrintWriter pw) throws IOException {
        pw.println("A");
        pw.println(animal);
    }

    /**
     * Recursively compute the number of animals in the tree rooted at 
     * this node. In this case, there just one animal at an animal node.
     * @return The number of animals in this node and lower.
     */
    public int numberOfAnimals() { return 1; }
}
