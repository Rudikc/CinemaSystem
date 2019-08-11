package ua.rudikc.cinema.utils;

import java.util.regex.Pattern;

public class AuthorizationHelper {



    public static boolean isPasswordCorrect(String password){

        //Minimum eight characters, at least one letter and one number pattern:
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

        return pattern.matcher(password).find();
    }
    public static boolean isEmailCorrect(String email){

        //Email validation pattern
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }
}
