package ua.rudikc.cinema.factory;

import java.util.HashMap;
import java.util.Map;

public class LanguageBundleFactory {
    private static final Map<String, String> localeMap =new HashMap<>();
    private static final String bundleName = "msg";

    static {
        localeMap.put("en_US",bundleName);
        localeMap.put("ru_RU",bundleName+"_ru_RU");
        localeMap.put("uk_UA",bundleName+"_uk_UA");
    }
    public static String getBundle(String string){
        return localeMap.get(string);
    }
}
