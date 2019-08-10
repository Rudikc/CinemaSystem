package ua.rudikc.cinema.command;

import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.UserSqlDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserSqlDao();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            if (userDao.isRegistered(email)) {
                return "seances";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "login";
    }
}
