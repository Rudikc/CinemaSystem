package ua.rudikc.cinema.command;

import ua.rudikc.cinema.dao.SessionDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSessionsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SessionDao sessionDao = (SessionDao) DaoFactory.getDao("sessionDao");
        try {
            List<Session> sessions = sessionDao.findSessionsByDate(request.getParameter("date"));
            request.setAttribute("sessions",sessions);

        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "sessions";
    }
}
