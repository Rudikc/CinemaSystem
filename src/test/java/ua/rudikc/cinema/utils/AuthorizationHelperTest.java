package ua.rudikc.cinema.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorizationHelperTest {

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect() {
        String password = "123456789Qwerty";
        assertTrue(AuthorizationHelper.isPasswordCorrect(password));
    }

    @Test
    public void shouldReturnTrueIfEmailIsCorrect() {
        String email = "mrudikc@gmail.com";
        assertTrue(AuthorizationHelper.isEmailCorrect(email));
    }
}