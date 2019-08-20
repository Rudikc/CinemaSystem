package ua.rudikc.cinema.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for language bundles
 */
public class LanguageBundleFactory {
    private static final Map<String, String> localeMap = new HashMap<>();
    private static final String bundleName = "msg";

    static {
        localeMap.put("en_GB", bundleName + "_en_GB");
        localeMap.put("ru_RU", bundleName + "_ru_RU");
        localeMap.put("uk_UA", bundleName + "_uk_UA");
    }

    /**
     * Takes a locale and gives bundle
     * @param string locale name
     * @return bundle name
     */
    public static String getBundle(String string) {
        return localeMap.get(string);
    }
}
