package ua.rudikc.cinema.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    /**
     * Base action interface for dispatcher servlet.
     */
    String execute (HttpServletRequest request, HttpServletResponse response);
}
