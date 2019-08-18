package ua.rudikc.cinema.controller.actions.utils;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.LanguageBundleFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ChangeLanguageAction implements Action {

    private static ArrayList<String> allowedLocales = new ArrayList<>();

    static {
        allowedLocales.add("ru_RU");
        allowedLocales.add("en_US");
        allowedLocales.add("uk_UA");
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String locale = request.getParameter("locale");
        if (!allowedLocales.contains(locale)) {
            locale = "en_US";
        }
        request.getSession().setAttribute("locale", locale);
        request.getSession().setAttribute("bundle", LanguageBundleFactory.getBundle(locale));
        return "index";
    }
}
