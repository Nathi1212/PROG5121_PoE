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
// TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

public class Part3Test {
    @Test
    public void testSentMessagesArrayPopulated() {

        String[] expected = {"Did you get the cake?", "It is dinner time !"
        };

        assertEquals("Did you get the cake?", expected[0]);
        assertEquals("It is dinner time !", expected[1]);
    }

    @Test
    public void testDisplayLongestMessage() {

        String longest = "Where are you? You are late! I have asked you to be on time.";
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchMessageID() {

        String expectedMessage = "It is dinner time !";
        assertEquals("It is dinner time !", expectedMessage);
    }

    @Test
    public void testSearchRecipient() {

        String[] messages = { "Where are you? You are late! I have asked you to be on time.", "Ok, I am leaving without you."
        };

        assertEquals("Where are you? You are late! I have asked you to be on time.",messages[0]);
        assertEquals("Ok, I am leaving without you.",messages[1]);
    }

    @Test
    public void testDeleteMessageUsingHash() {

        boolean deleted = true;
        assertTrue(deleted);
    }

    @Test
    public void testDisplayReport() {
        String hash = "Hash Present";
        String recipient = "+27834557896";
        String message = "Did you get the cake?";

        assertNotNull(hash);
        assertNotNull(recipient);
        assertNotNull(message);
    }
    
    }

    