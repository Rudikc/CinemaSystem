package ua.rudikc.cinema.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }
}
