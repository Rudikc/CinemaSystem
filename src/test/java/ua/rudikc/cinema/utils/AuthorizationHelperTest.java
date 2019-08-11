package ua.rudikc.cinema.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorizationHelperTest {

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect() {
        String password = "10133425Max";
        assertTrue(AuthorizationHelper.isPasswordCorrect(password));
    }

    @Test
    public void shouldReturnTrueIfEmailIsCorrect() {
        String email = "rudikc@gmail.com";
        assertTrue(AuthorizationHelper.isEmailCorrect(email));
    }
}