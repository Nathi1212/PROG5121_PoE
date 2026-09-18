/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Student
 */
import com.mycompany.oopbasics.Login;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testRegisterUser_UsernameCorrect() {
        String expected = "The two above conditions have been met, and the user has been registered successfully.";
        String actual = Login.registerUser("Ch&&sec@ke99!", "kyl_1", "+27 9765435343");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_UsernameIncorrect() {
        String expected = "The username is incorrectly formatted.";
        String actual = Login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "3456789");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_PasswordMeetsComplexity() {
        String expected = "The two above conditions have been met, and the user has been registered successfully.";
        String actual = Login.registerUser("kyl_1", "Ch&&sec@ke99!", "0810821");
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser_PasswordDoesNotMeetComplexity() {
        String expected = "The password does not meet the complexity requirements.";
        String actual = Login.registerUser("kyl_1", "password", "45678456");
        assertEquals(expected, actual);
    }

    @Test
    public void testCellPhone_CorrectlyFormatted() {
        assertTrue(Login.checkZACellphoneNumber("+27838958976"));
    }

    @Test
    public void testCellPhone_IncorrectlyFormatted() {
        assertFalse(Login.checkZACellphoneNumber("08956553"));
    }
    
    

    @Test
    public void testLoginSuccessful() {
        assertTrue(Login.loginUser("kyl_1", "kyl_1", "Ch&&sec@ke99!", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(Login.loginUser("kyl_1", "kyl_1", "wrongPass", "Ch&&sec@ke99!"));
    }

    @Test
    public void testUsernameCorrectlyFormattedBoolean() {
        assertTrue(Login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormattedBoolean() {
        assertFalse(Login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexityBoolean() {
        assertTrue(Login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityBoolean() {
        assertFalse(Login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormattedBoolean() {
        assertTrue(Login.checkZACellphoneNumber("+27838958976"));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormattedBoolean() {
        assertFalse(Login.checkZACellphoneNumber("08956553"));
    }
}
