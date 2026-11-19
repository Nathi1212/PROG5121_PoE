/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.portofevid;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class PortOfEvid {

     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Phone number: ");
        String phone = sc.nextLine();
        while(!Login.checkZACellphoneNumber(phone)){
            System.out.println("Incorrect format! Enter the correct n phone");
            phone = sc.nextLine();
        }

        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        while(!Login.checkUserName(user)){
            System.out.println("Incorrect username entered! Enter uesrname.");
            user = sc.nextLine();        
        }

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        while(!Login.checkPasswordComplexity(pass)){
            System.out.println("Incorect password! please enter password");
            pass = sc.nextLine();
        }

        String registrationStatus = Login.registerUser(pass, user, phone);

        System.out.println(registrationStatus);

        if (Login.checkUserName(user)
                && Login.checkPasswordComplexity(pass)) {

            System.out.println("\nLOGIN");
        
            System.out.print("Enter login username: ");
            String enteredUser = sc.nextLine();

            System.out.print("Enter login password: ");
            String enteredPass = sc.nextLine();

            boolean success = Login.loginUser(enteredUser, user, enteredPass, pass);

            String message = Login.returnLoginStatus(success, firstName, lastName);

            System.out.println(message);

            if (success) {
                System.out.println("Welcome to QuickChat");
                System.out.print("How many messages would you like to send? ");

                int totalMessages = Integer.parseInt(sc.nextLine());

                int messagesSent = 0;
                int messageNumber = 1;

                int choice;
                Message msg = null;
                do {

                    System.out.println("\n1. Send Messages");
                    System.out.println("2. Show recently sent messages");
                    System.out.println("3. Stored messages");
                    System.out.println("4. Quit");

                    System.out.print("Select an option: ");

                    choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {

                        case 1:

                            if (messageNumber > totalMessages) {

                                System.out.println("You have reached the maximum number of messages.");

                                break;
                            }

                            System.out.print("Enter recipient number: ");

                            String recipient = sc.nextLine();

                            System.out.print("Enter message: ");

                            String text = sc.nextLine();

                            String messageID = Message.generateMessageID();
                           

                            msg = new Message(messageID, recipient, text, messageNumber);

                            System.out.println(msg.checkRecipientCell());

                            if (msg.checkRecipientCell().contains("incorrectly")) {

                                break;
                            }

                            if (text.length() > 250) {

                                System.out.println( "Please enter a message of less than 250 characters.");

                                break;
                            }

                            msg.createMessageHash();

                            System.out.println("\n1. Send Message");
                            System.out.println("2. Disregard Message");
                            System.out.println("3. Store Message");

                            int action = Integer.parseInt(sc.nextLine());

                            switch (action) {

                                case 1:
                                    
                                    msg.addSentMessage();
                                    System.out.println(msg.sentMessage());
                                    System.out.println(msg.printMessage());
                                    messagesSent++;
                                    messageNumber++;

                                    break;

                                case 2:

                                    System.out.println("Press 0 to delete the message");

                                    int delete = Integer.parseInt(sc.nextLine());

                                    if (delete == 0) {
                                        msg.addDisregardedMessage();

                                        System.out.println("Message deleted");
                                    }

                                    break;
                                    
                                    

                                case 3:
                                    msg.addStoredMessage();

                                    System.out.println(msg.storeMessage());

                                    JsonStorage.saveMessage(msg);
                                    
                                    System.out.println("Message Hash: "+ msg.messageHash) ;

                                    messageNumber++;

                                    break;

                                default:

                                    System.out.println("Invalid option");
                            }

                            break;
                        
                        case 2:

                           msg.displaySentMessages();
                           
                           break;
                            
                        case 3:
                            System.out.println("\nStored Messages");

                            System.out.println("1. Display Stored Messages");
                            System.out.println("2. Display Longest Message");
                            System.out.println("3. Search Message ID");
                            System.out.println("4. Search Recipient");
                            System.out.println("5. Delete Message Using Hash");
                            System.out.println("6. Display Report");
                        int storedOption = Integer.parseInt(sc.nextLine());

    switch(storedOption) {

        
        case 1:

            if (msg == null) {
               System.out.println("No messages available.");
            break;
            }
            msg.displayStoredMessages();

            break;

        case 2:

            msg.displayLongestMessage();

            break;
        case 3:

            System.out.print("Enter Message ID: ");
            String id = sc.nextLine();

            msg.searchMessageID(id);

            break;
        case 4:

            System.out.print("Enter recipient number: ");

            String recipientNumber = sc.nextLine();

            msg.searchRecipient(recipientNumber);

            break;
        case 5:

            System.out.print("Enter message hash: ");
            String hash = sc.nextLine();

            msg.deleteMessageByHash(hash);

            break;
        case 6:

            msg.displayReport();

            break;

        default:

            System.out.println("Option not implemented yet");
    }

          
                    }

                } while (choice != 4);
            }
        }

        sc.close();
    }
}