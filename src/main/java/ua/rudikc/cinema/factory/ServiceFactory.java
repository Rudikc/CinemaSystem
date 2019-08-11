package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.service.SeanceService;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static Map<String, Object> serviceMap = new HashMap<>();

    static {
        serviceMap.put("seanceService",new SeanceService());
    }

    public static Object getService(String name){
        return serviceMap.get(name);
    }
}
