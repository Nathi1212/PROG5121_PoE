/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.portofevid;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
public class JsonStorage {
    public static void saveMessage(Message msg) {

        Gson gson = new Gson();

        try {

            FileWriter writer = new FileWriter("messages.json", true);

            gson.toJson(msg, writer);

            writer.write(System.lineSeparator());

            writer.close();

        } catch(IOException e) {

            System.out.println(
                "Error storing message.");
        }
    }
    
}
