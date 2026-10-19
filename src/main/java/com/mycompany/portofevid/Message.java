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
    
}
