package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.dao.sqlimplementation.*;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {


    public static final String FILM_DAO = "filmDao";
    public static final String FILM_GENRE_DAO = "filmGenreDao";
    public static final String ORDER_DAO = "orderDao";
    public static final String SEAT_DAO = "seatDao";
    public static final String SEAT_TYPE_DAO = "seatTypeDao";
    public static final String SEANCE_DAO = "seanceDao";
    public static final String TICKET_DAO = "ticketDao";
    public static final String USER_DAO = "userDao";

    private static Map<String, Object> daoMap = new HashMap<>();

    static {
        daoMap.put(FILM_DAO, new FilmSqlDao());
        daoMap.put(FILM_GENRE_DAO, new FilmGenreSqlDao());
        daoMap.put(ORDER_DAO, new OrderSqlDao());
        daoMap.put(SEAT_DAO, new SeatSqlDao());
        daoMap.put(SEAT_TYPE_DAO, new SeatTypeSqlDao());
        daoMap.put(SEANCE_DAO, new SeanceSqlDao());
        daoMap.put(TICKET_DAO, new TicketSqlDao());
        daoMap.put(USER_DAO, new UserSqlDao());
    }

    public static Object getDao(String name){
        return daoMap.get(name);
    }
}
