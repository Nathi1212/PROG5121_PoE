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

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        String registrationStatus =
                Login.registerUser(pass, user, phone);

        System.out.println(registrationStatus);

        if (Login.checkUserName(user)
                && Login.checkPasswordComplexity(pass)) {

            System.out.println("\nLOGIN");

            System.out.print("Enter login username: ");
            String enteredUser = sc.nextLine();

            System.out.print("Enter login password: ");
            String enteredPass = sc.nextLine();

            boolean success = Login.loginUser(
                    enteredUser,
                    user,
                    enteredPass,
                    pass);

            String message =
                    Login.returnLoginStatus(
                            success,
                            firstName,
                            lastName);

            System.out.println(message);

            if (success) {

                System.out.println("Welcome to QuickChat");

                System.out.print(
                        "How many messages would you like to send? ");

                int totalMessages =
                        Integer.parseInt(sc.nextLine());

                int messagesSent = 0;
                int messageNumber = 1;

                int choice;

                do {

                    System.out.println("\n1. Send Messages");
                    System.out.println("2. Show recently sent messages");
                    System.out.println("3. Quit");

                    System.out.print("Select an option: ");

                    choice =
                            Integer.parseInt(sc.nextLine());

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

                            Message msg = new Message(messageID, recipient, text, messageNumber);

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

                                    System.out.println(msg.sentMessage());

                                    System.out.println(msg.printMessage());
                                    messagesSent++;
                                    messageNumber++;

                                    break;

                                case 2:

                                    System.out.println("Press 0 to delete the message");

                                    int delete = Integer.parseInt(sc.nextLine());

                                    if (delete == 0) {

                                        System.out.println("Message deleted");
                                    }

                                    break;

                                case 3:

                                    System.out.println(msg.storeMessage());

                                    JsonStorage.saveMessage(msg);

                                    messageNumber++;

                                    break;

                                default:

                                    System.out.println("Invalid option");
                            }

                            break;

                        case 2:

                            System.out.println("Coming Soon.");

                            break;

                        case 3:

                            System.out.println("Total messages sent: " + messagesSent);

                            System.out.println("Goodbye.");

                            break;

                        default:

                            System.out.println("Invalid option");

                    }

                } while (choice != 3);
            }
        }

        sc.close();
    }
}