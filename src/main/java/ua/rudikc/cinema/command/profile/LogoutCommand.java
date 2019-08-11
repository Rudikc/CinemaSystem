package ua.rudikc.cinema.command.profile;

import ua.rudikc.cinema.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user",null);
        return "index";
    }
}
