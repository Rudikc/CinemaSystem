package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.service.SeanceService;
import ua.rudikc.cinema.service.SeatService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static Map<String, Object> serviceMap = new HashMap<>();

    static {
        serviceMap.put("seanceService",new SeanceService());
        serviceMap.put("seatService",new SeatService());
    }

    public static Object getService(String name){
        return serviceMap.get(name);
    }
}
