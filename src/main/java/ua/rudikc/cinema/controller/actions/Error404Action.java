package ua.rudikc.cinema.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error404Action implements Action{
    /**
     * Action to that returns 404 error page to user.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "404";
    }
}
