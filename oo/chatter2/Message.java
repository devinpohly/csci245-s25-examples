package chatter2;
/**
 * Message.java
 * 
 * Class to model a message in Chatter (a Twitter-like
 * system)
 * 
 * @author Thomas VanDrunen
 * CSCI 235, Wheaton College
 * Sept 14, 2010
 * In-class example
 */

import java.util.Date;  // for date formatting

public class Message  implements Comparable<Message> {

	private static int numInstances;

	static {
		numInstances = 0;
		System.out.println("Static initializer executed");
	}

	/**
	 * The (text) content of this message
	 */
	private String text;

	/**
	 * The name of the user who sent this message
	 */
	private String userName;

	/**
	 * The codes used to identify categories relevant
	 * for this message
	 */
	private String[] poundTags;

	/**
	 * Timestamp of when this message was created
	 */
	private long date;

	/**
	 * Plain constructor
	 * @param text The content of the message
	 * @param userName The user who sent this
	 * @param poundTags Array of relevant categories (will be cloned)
	 */
	public Message(String text, String userName, String[] poundTags) {
		this.text = text;
		this.userName = userName;
		this.poundTags = new String[poundTags.length];
		for (int i = 0; i < poundTags.length; i++)
			this.poundTags[i] = poundTags[i];
		this.date = System.currentTimeMillis();
		numInstances++;
	}

	/**
	 * Dummy constructor generating default text
	 * @param userName The user who sent this
	 */
	public Message(String userName) {
		this("default text", userName, new String[0]);
	}

	/**
	 * Make a string representation of this message.
	 * @return A string displaying this message
	 */
	public String toString() {
		// the string we're returning, built up across
		// several steps
		String toReturn = userName + "\t" + (new Date(date)) + "\n" + 
			text + "\n";
		for (int i = 0; i < poundTags.length; i++)
			toReturn += "#" + poundTags[i];
		toReturn += "\n";
		return toReturn;
	}

	/**
	 * Compare two messages. Two messages are equal if
	 * they have the same content and the same sending user.
	 * @param o The other object to compare this to
	 * @return true if they have the same content, false otherwise
	 */
	public boolean equals(Object o){
		if (o instanceof Message) {
			Message other = (Message) o; 
			return userName.equals(other.userName)&&
				text.equals(other.text);
		}
		else return false;
	}

	/**
	 * Determine how to order this message and a given one.
	 * Order messages alphabetically by user, and
	 * secondarily by timestamp.  
	 * @param other The other message in the comparison
	 * @return a negative value if this message comes first, 0 if they are
	 * incomparable, a positive value  if the other comes first
	 */
	public int compareTo(Message other) {
		int userNameComparison = userName.compareTo(other.userName);
		if (userNameComparison != 0) return userNameComparison;
		else if (date < other.date) return -1;
		else if (date == other.date) return 0;
		else return 1;
	}
	//   a.compareTo(b)     < 0   if   a < b
	//   a.compareTo(b)     = 0   if   a = b
	//   a.compareTo(b)     > 0   if   a > b

	/**
	 * Get the primary category for this message,
	 * empty string if none
	 * @return The primary category for this message, empty
	 * string if none
	 */
	public String primaryPoundTag() {
		if (poundTags.length > 0) return poundTags[0];
		else return "";
	}

	/**
	 * Get the date when this message was made
	 * @return the date when this message was made
	 */
	public long date() { 
		return date;
	}

	public static int getNumInstances() { 
		return numInstances; 
	}

	/**
	 * Main method for testing.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hello");
		String[] pounds = {"FranzLiszt", "TomSwifities"};
		Message msg = 
			new Message("\"I have lost all my Hungarian sheet music,\" he said listlessly.",
					"Xerxes", pounds);
		System.out.println(msg.toString());
		System.out.println("There are " + Message.getNumInstances() + " instances.");
		new Message("hello", "bob", new String[0]);
	}
}
