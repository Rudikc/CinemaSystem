package ua.rudikc.cinema.utils;

import java.util.regex.Pattern;

/**
 * Util class for data validation
 */
public class AuthorizationHelper {


    /**
     * Return true if password matches regex
     * @param password
     * @return
     */
    public static boolean isPasswordCorrect(String password){

        //Minimum eight characters, at least one letter and one number pattern:
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

        return pattern.matcher(password).find();
    }

    /**
     * Return true if email matches regex
     * @param email
     * @return
     */
    public static boolean isEmailCorrect(String email){

        //Email validation pattern
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }
}
