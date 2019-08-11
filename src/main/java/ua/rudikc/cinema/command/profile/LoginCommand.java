package ua.rudikc.cinema.command.profile;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.UserSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserSqlDao();
        User user = null;

        if (request.getParameter("email") == null) {
            return "login";
        }
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");

        try {
            user = userDao.findByEmailAndPassword(email, password);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (user == null) {
            request.getSession().setAttribute("loginMessage","index.login.error");
            return "login";
        }
        request.setAttribute("user", user);

        return "seances";
    }
}
