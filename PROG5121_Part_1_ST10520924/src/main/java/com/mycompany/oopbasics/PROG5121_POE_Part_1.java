/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oopbasics;

import java.util.Scanner;


/**
 *
 * @author Student
 */
public class PROG5121_POE_Part_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Firstname: ");
        String firstName = sc.nextLine();
        
        System.out.println("Enter Last name: ");
        String lastName = sc.nextLine();
        
        System.out.println("Enter Phone number: ");
        String phone = sc.nextLine();
        
        System.out.println("Enter Username: ");
        String user = sc.nextLine();
        
        System.out.println("Enter Password: ");
        String pass = sc.nextLine();
        
        String registrationStatus = Login.registerUser(pass, user, phone);
        System.out.println(registrationStatus);
        
        if (Login.checkUserName(user) && Login.checkPasswordComplexity(pass)) {
            System.out.println("\n-USER LOGIN-");
        
        System.out.println("Enter login username: ");
        String enteredUser = sc.nextLine();
        
        System.out.println("Enter login password: ");
        String enteredPass = sc.nextLine();
        
        System.out.println(Login.checkUserName(user));
        System.out.println(Login.checkPasswordComplexity(pass));
        
        boolean success = Login.loginUser(enteredUser, user, enteredPass, pass);
        String meessage = Login.returnLoginStatus(success, firstName, lastName);
    }    
    sc.close();
}

class Login{
    String user;
    String pass;
    String phone;
    
    
    public static boolean checkUserName(String user){
        return user.contains("_") && user.length()<=5;
    }
    public static Boolean checkPasswordComplexity(String pass){  
        boolean hasCapital = pass.matches(".*[A-Z]*.");
        boolean hasNumber = pass.matches(".*[0-9]*");
        boolean hasSpecial = pass.matches(".*[!@#$%^&*()?/>=+-_]");
        boolean hasMinLength = pass.length() >= 8;
        
        return hasCapital && hasNumber && hasMinLength && hasSpecial;
    }
    public static Boolean checkZACellphoneNumber(String phone){
        return phone.contains("+27") && phone.length()<=12;
    }
    
    public static String registerUser(String pass, String user, String phone){
        if(!checkUserName(user)){
            return "Username not correctly formatted, please ensure that your username contains an underscore and has no more than 5 characters.";
        }      
        if(!checkPasswordComplexity(pass)){
            return "Password not correctly formatted, please ensure that your password contains at least 8 charecters capital letter, a special symbol and a number.";
        }
        System.out.print("Username and Password successfully captured.");
        
        if(checkZACellphoneNumber(phone)){
            return "Cellphone number sucessfully added";
        }else{
            return "Cellphone number incorectly formatted or does not contain international code";
        }
               
   
    }
    public static boolean loginUser(String enteredUser, String storedUser,String enteredPass, String storedPass){
        return enteredUser.equals(storedUser) && enteredPass.equals(storedPass);
    }
    public static String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName){
        if(isLoggedIn){
            return "Welcome " + firstName + "," + lastName + "it is great to see you again";
        }else{
            return "Usernmae or password incorrect, please try again.";
        }
    }
}              
}
