package animals;
/**
 * Question.java
 * 
 * A class to stand for a question in the knowledge base. This represents
 * a non-leaf node in the tree. It has two nodes, each of which represents
 * a follow-up (either another question or a final guess), depending
 * on whether the answer to the present question is yes or no.
 * 
 * @author Thomas VanDrunen
 * Wheaton College, CS 241, Spring 2005
 * In-class example
 * Apr 27, 2005
 */

import java.io.*;
import java.util.*;

public class Question implements Node {

    /**
     * The next question to ask or the animal to guess if the user answers
     * yes.
     */
    private Node yes;

    /**
     * The next question to ask or the animal to guess if the user answers
     * no.
     */
    private Node no;

    /**
     * The question (or prompt) to ask the user at this point.
     */
    private String prompt;

    /**
     * Constructor, given all the data directly.
     * @param prompt The question to ask
     * @param yes The follow-up if the answer is yes
     * @param no The follow-up if the answer is no
     */
    public Question(String prompt, Node yes, Node no) {
	this.prompt = prompt;
	this.yes = yes;
	this.no = no;
    }

    /**
     * Constructor, recursively reading in the data from a BufferedReader.
     * The question should be the next line, followed by a series
     * standing for the yes question or animal, followed by a series
     * standing for the no question or animal. Read the prompt, and then,
     * depending on what the next input is, create a Question or Animal
     * by passing the BufferedReader to the respective constructors.
     * This assumes the Q indicated this is a question has already been 
     * read, and it consumes the Q or A indicating what the next item is.
     * @param br The buffered read from which to read.
     */
    public Question(Scanner file) throws IOException {
	prompt = file.nextLine();
	if (file.nextLine().equals("Q"))
	    yes = new Question(file);
	else
	    yes = new Animal(file);
	if (file.nextLine().equals("Q"))
	    no = new Question(file);
	else
	    no = new Animal(file);
    }

    /**
     * Recursively ask the user questions until an animal is guessed.
     * Print the question, read a query, and ask whatever next question or
     * guess is appropriate. Update yes or no, in case the tree has changed
     * @returns A node to stand in the place of this one, in case the tree 
     * has changed.
     */
     public Node ask() {
         System.out.println(prompt);
         String answer = Animals.keyboard.nextLine();  // query from the user
         if (answer.equals("y") || answer.equals("Y"))
             yes = yes.ask();
         else
             no = no.ask();
         return this;
    }
    
    /**
     * Recursively write the tree rooted at this node to the given 
     * PrintWriter
     * Print a Q to indicate that this is a question, print the 
     * question itself, and then print the yes and no nodes, 
     * passing them the PrintWriter.
     * @param pw The PrintWriter on which to write this output.
     */
    public void print(PrintWriter pw) throws IOException {
	pw.println("Q");
	pw.println(prompt);
	yes.print(pw);
	no.print(pw);
    }

    /**
     * Recursively compute the number of animals in the tree rooted 
     * at this node.
     * Here it is the sum fo the number of animals in the two subtrees
     * rooted here.
     * @return The number of animals in this node and lower.
     */
    public int numberOfAnimals() {
	return yes.numberOfAnimals() + no.numberOfAnimals();
    }

}
