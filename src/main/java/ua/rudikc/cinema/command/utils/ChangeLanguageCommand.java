package ua.rudikc.cinema.command.utils;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.factory.LanguageBundleFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String locale = request.getParameter("locale");
        request.getSession().setAttribute("locale",locale);
        request.getSession().setAttribute("bundle", LanguageBundleFactory.getBundle(locale));
        return "index";
    }
}
