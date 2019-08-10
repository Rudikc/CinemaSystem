package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.dao.sqlimplementation.*;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    private static Map<String, Object> daoMap = new HashMap<>();

    static {
        daoMap.put("filmDao", new FilmSqlDao());
        daoMap.put("filmGenreDao", new FilmGenreSqlDao());
        daoMap.put("orderDao", new OrderSqlDao());
        daoMap.put("seatDao", new SeatSqlDao());
        daoMap.put("seatTypeDao", new SeatTypeSqlDao());
        daoMap.put("seanceDao", new SeanceSqlDao());
        daoMap.put("ticketDao", new TicketSqlDao());
        daoMap.put("userDao", new UserSqlDao());
    }

    public static Object getDao(String name){
        return daoMap.get(name);
    }
}
