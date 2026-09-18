/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopbasics;

/**
 *
 * @author Student
 */

public class Login{
    String user;
    String pass;
    String phone;
    String firstName;
    String lastName;
    
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
            return "The two above conditions have been met, and the user has been registered successfully";
        }      
        if(!checkPasswordComplexity(pass)){
            return "Password incorrectly formatted";
        }
        System.out.print("Username and Password successfully captured.");
        
        if(checkZACellphoneNumber(phone)){
            return "The two above conditions have been met and the user has been registered successfully";
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

