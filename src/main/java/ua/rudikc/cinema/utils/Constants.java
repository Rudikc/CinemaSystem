package ua.rudikc.cinema.utils;

public class Constants {

    public static final String JSP_PATH = "/jsp/%s.jsp";

    public static final String LOCALE = "locale";
    public static final String BUNDLE = "bundle";

    //Database table names

    //Users
    public static final String USER_ID = "user_id";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_PHONE = "phone";
    public static final String USER_ROLE = "user_role";

    //Tickets
    public static final String TICKET_ID = "ticket_id";
    public static final String TICKET_SEAT_ID = "seat_id";
    public static final String TICKET_SEANCE_ID = "seance_id";
    public static final String TICKET_ORDER_ID = "order_id";

    //Seances
    public static final String SEANCE_ID = "seance_id";
    public static final String SEANCE_START= "seance_start";
    public static final String SEANCE_END= "seance_end";
    public static final String SEANCE_FILM_ID= "film_id";
    public static final String SEANCE_TICKET_PRICE = "ticket_price";

    //Seat types
    public static final String SEAT_TYPE_ID = "seat_type_id";
    public static final String SEAT_TYPE_TYPE = "type";
    public static final String SEAT_TYPE_PRICE_MULTIPLIER = "price_multiplier";

    //Seats
    public static final String SEAT_ID = "seat_id";
    public static final String SEAT_ROW = "seat_row";
    public static final String SEAT_PLACE = "seat_place";
    public static final String SEAT_SEAT_TYPE_ID = "seat_type_id";

    //Orders
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_USER_ID = "user_id";
    public static final String ORDER_PRICE = "price";
    public static final String ORDER_ORDER_TIME = "order_time";

    //Films
    public static final String FILM_ID = "film_id";
    public static final String FILM_NAME = "film_name";
    public static final String FILM_director = "director";
    public static final String FILM_PREMIERE_DATE = "premiere_date";
    public static final String FILM_DURATION = "duration";
    public static final String FILM_POSTER_PIC = "poster_pic";

    //Film genres
    public static final String FILM_GENRE_ID = "film_genre_id";
    public static final String FILM_GENRE_NAME = "film_genre_name";

}
