package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.service.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for services
 */
public class ServiceFactory {
    private static Map<String, Object> serviceMap = new HashMap<>();

    static {
        serviceMap.put("seanceService",new SeanceService());
        serviceMap.put("seatService",new SeatService());
        serviceMap.put("ticketService",new TicketService());
        serviceMap.put("orderService",new OrderService());
        serviceMap.put("filmService",new FilmService());

    }

    public static Object getService(String name){
        return serviceMap.get(name);
    }
}
