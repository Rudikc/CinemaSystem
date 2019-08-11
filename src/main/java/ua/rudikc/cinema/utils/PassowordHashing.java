package ua.rudikc.cinema.utils;

public class PassowordHashing {

    public static String hashPassword(String password) {
        //todo stronger hashing for real projects
        return String.valueOf(password.hashCode());
    }
}
