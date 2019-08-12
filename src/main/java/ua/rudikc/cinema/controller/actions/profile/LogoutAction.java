package ua.rudikc.cinema.controller.actions.profile;

import ua.rudikc.cinema.controller.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user",null);
        return "index";
    }
}
