package animals;
/**
 * Node.java
 * 
 * This interface provides a super type for Animals and Questions.
 * 
 * @author Thomas VanDrunen
 * Wheaton College, CS 241, Spring 2005
 * In-class example
 * Apr 27, 2005
 */

import java.io.*;

public interface Node {

    /**
     * Recursively ask the user questions until an animal is guessed.
     * @returns A node to stand in the place of this one, in case 
     * the tree has changed.
     */
    public Node ask();

    /**
     * Recursively write the tree rooted at this node to the given 
     * PrintWriter
     * @param pw The PrintWriter on which to write this output.
     */
    public void print(PrintWriter pw) throws IOException;

    /**
     * Recursively compute the number of animals in the tree rooted 
     * at this node.
     * @return The number of animals in this node and lower.
     */
    public int numberOfAnimals();
}
