package chatter1;

import java.util.Date;



public class Message {
	
    public String text;
    public String userName;
    public String[] poundTags;
    public long date;

    public static void display(Message msg) {
        System.out.println(msg.userName + "\t" + (new Date(msg.date)));
        System.out.println(msg.text);
        for (int i = 0; i < msg.poundTags.length; i++)
            System.out.print("#" + msg.poundTags[i]);
        System.out.println("\n\n");
    }
	
    public static void main(String[] args) {
    
    	Message msg = new Message();
        msg.text = "\"I'm making pancakes,\" he said flippantly.";
        msg.userName = "Rugosa";
        msg.poundTags = new String[2];
        msg.poundTags[0] = "TomSwifties";
        msg.poundTags[1] = "Pancakes";
        msg.date = System.currentTimeMillis();
        
        display(msg);
    }
    
}

