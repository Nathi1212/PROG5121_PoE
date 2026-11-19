/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.portofevid;

/**
 *
 * @author Student
 */
import java.util.Random;

public class Message {

    String messageID;
    String recipient;
    String message;
    String messageHash;
    int messageNumber;
    
    static String[] sentMessages = new String[100];
    static String[] ids = new String[100];
    static String[] disregardedMessages = new String[100];
    static String[] storedMessages = new String[100];
    static String[] messageHashes = new String[100];
    static String[] messageIDs = new String[100];
    static String[] recipients = new String[100];
    
    static String[] storedMessageIDs = new String[100];
    static String[] storedRecipients = new String[100];
    static String[] storedHashes = new String[100];
    
    static String[] disregardedMessageIDs = new String[100];
    static String[] disregardedRecipients = new String[100];
    static String[] disregardedHashes = new String[100];
    
   
    static int sentCount = 0;
    static int storedCount = 0;
    static int disregardedCount = 0;


    public Message(String messageID, String recipient, String message, int messageNumber) {

        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;
    }

    public static String generateMessageID() {

        Random random = new Random();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            id.append(random.nextInt(10));
        }

        return id.toString();
    }

    public boolean checkMessageID() {

        return messageID.matches("\\d{10}");
    }

    public String checkRecipientCell() {

        if (recipient.startsWith("+27") && recipient.length() <= 12) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number incorrectly formatted.";
    }

    public boolean checkMessageLength() {

        return message.length() <= 250;
    }

    public String createMessageHash() {

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        messageHash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;

        return messageHash;
    }

    public String sentMessage() {

        return "Message successfully sent.";
    }

    public String storeMessage() {

        return "Message successfully stored.";
    }

    public String printMessage() {

        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;
    }

    public static int returnTotalMessages(int totalMessages) {

        return totalMessages;
    }

    public String getMessageID() {

        return messageID;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getMessage() {

        return message;
    }

    public String getMessageHash() {

        return messageHash;
    }

    public int getMessageNumber() {

        return messageNumber;
    }
     public String disregardMessage(){
        return "Press 0 to delete the message";
    }
     
    
    public void addSentMessage() {
        System.out.println("Saving:");
        sentMessages[sentCount] = message;
        messageHashes[sentCount] = messageHash;
        messageIDs[sentCount] = messageID;
        recipients[sentCount] = recipient;
        sentCount++;   
    }
    
    public void addDisregardedMessage() {
        disregardedMessages[disregardedCount] = message;
        disregardedMessageIDs[disregardedCount] = messageID;
        disregardedRecipients[disregardedCount] = recipient;
        disregardedHashes[disregardedCount] = messageHash;
        disregardedCount++;

    
    }
    
    public void addStoredMessage() {
        storedMessages[storedCount] = message;
        storedMessageIDs[storedCount] = messageID;
        storedRecipients[storedCount] = recipient;
        storedHashes[storedCount] = messageHash;

        storedCount++;
    }
    public void displayStoredMessages() {
        for(int i = 0; i < storedCount; i++) {
             if (storedMessages[i] != null) {
             System.out.println(storedMessages[i]);
             }
        }
    }
    public void displayLongestMessage() {String longest = "";

        for(int i = 0; i < storedCount; i++) {
            if(storedMessages[i] != null && storedMessages[i].length() > longest.length()) {
            longest = storedMessages[i];
            }
        }

    System.out.println("Longest Message: " + longest);
    }
    public void searchMessageID(String id) {

    for (int i = 0; i < storedCount; i++) {

        if (storedMessageIDs[i] != null &&
            storedMessageIDs[i].equals(id)) {

            System.out.println("Recipient: "
                    + storedRecipients[i]);

            System.out.println("Message: "
                    + storedMessages[i]);

            return;
        }
    }

    System.out.println("Message not found");
}
    public void searchRecipient(String number) {
        
        boolean found = false;

    for (int i = 0; i < storedCount; i++) {

        if (storedRecipients[i] != null &&
                storedRecipients[i].equals(number)) {

            System.out.println("Message: "
                    + storedMessages[i]);

            found = true;
        }
    }

    if (!found) {

        System.out.println("Recipient not found");
    }
    }
    public void deleteMessageByHash(String hash) {

        for (int i = 0; i < storedCount; i++) {

        if (storedHashes[i] != null &&
            storedHashes[i].equals(hash)) {

            System.out.println("Message:");
            System.out.println(storedMessages[i]);

            storedMessages[i] = null;
            storedHashes[i] = null;
            storedRecipients[i] = null;
            storedMessageIDs[i] = null;

            System.out.println("Successfully deleted");

            return;
        }
    }

    System.out.println("Message not found");
    }   
    public void displayReport() {
        System.out.println("\nMESSAGE REPORT");

    for (int i = 0; i < storedCount; i++) {

        System.out.println("------------------");
        System.out.println("Message Hash: " + storedHashes[i]);
        System.out.println("Recipient: " + storedRecipients[i]);
        System.out.println("Message: " + storedMessages[i]); 
        System.out.println("Message ID: " + storedMessageIDs[i]);
        System.out.println("------------------");
    }
    }
  
    public void displaySentMessages() {

        System.out.println("\nRecently Sent Messages");

        for (int i = 0; i < sentCount; i++) {
            if (sentMessages[i] != null) {
                System.out.println(sentMessages[i]);
            }
        }
    }
   

}

    
    

   
                
            
        
                


