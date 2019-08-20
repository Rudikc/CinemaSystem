package ua.rudikc.cinema.utils;

/**
 * Util class for password hashing
 */
public class PasswordHashing {

    public static String hashPassword(String password) {
        //todo stronger hashing for real projects
        return String.valueOf(password.hashCode());
    }
}
