package ua.rudikc.cinema.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordHashingTest {

    @Test
    public void hashPassword() {
        String password = "123456789Qwer";
        String passwordHash = String.valueOf(password.hashCode());

        assertNotEquals(password,PasswordHashing.hashPassword(password));
        assertEquals(passwordHash,PasswordHashing.hashPassword(password));
    }
}