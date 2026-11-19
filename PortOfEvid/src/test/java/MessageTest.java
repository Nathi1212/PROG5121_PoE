/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */


public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {

        Message message = new Message( "0012345678", "+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);

        assertEquals("Message ready to send.", message.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {

        String longMessage = "a".repeat(260);

        Message message = new Message("0012345678", "+27718693002", longMessage, 0);

        assertEquals( "Message exceeds 250 characters by 10, please reduce the size.",
                message.checkMessageLength());
    }

    @Test
    public void testRecipientNumberSuccess() {

        Message message = new Message("0012345678", "+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);

        assertEquals("Cell phone number successfully captured.",
                message.checkRecipientCell());
    }

    @Test
    public void testRecipientNumberFailure() {

        Message message = new Message("0012345678", "08575975898", "Hi Keegan, did you receive the payment?", 1);

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                message.checkRecipientCell());
    }

    @Test
    public void testMessageHash() {

        Message message = new Message("0012345678", "+27718693002", "Hi Mike can you join us for dinner tonight", 0);

        assertEquals("00:0:HITONIGHT", message.createMessageHash());
    }

    @Test
    public void testMessageIDCreated() {

        String messageID = Message.generateMessageID();

        assertEquals(10, messageID.length());
    }

    @Test
    public void testMessageIDNumeric() {

        String messageID = Message.generateMessageID();

        assertTrue(messageID.matches("\\d{10}"));
    }

    @Test
    public void testCheckMessageID() {

        Message message = new Message("1234567890", "+27718693002", "Hello", 1);

        assertTrue(
                message.checkMessageID());
    }

    @Test
    public void testSendMessage() {

        Message message = new Message( "1234567890", "+27718693002", "Hello", 1);

        assertEquals("Message successfully sent.", message.sentMessage());
    }

    @Test
    public void testDisregardMessage() {

        Message message = new Message("1234567890", "+27718693002", "Hello", 1);

        assertEquals("Press 0 to delete the message.", message.disregardMessage());
    }

    @Test
    public void testStoreMessage() {

        Message message = new Message("1234567890", "+27718693002", "Hello", 1);

        assertEquals("Message successfully stored.", message.storeMessage());
    }

    @Test
    public void testReturnTotalMessages() {

        assertEquals(2, Message.returnTotalMessages(2));
    }
}
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

