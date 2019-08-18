package ua.rudikc.cinema.controller.actions.profile;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.UserSqlDao;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.utils.PasswordHashing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LoginAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole() == UserRole.USER || user.getRole() == UserRole.ADMIN){
            return CommandFactory.defineCommand("/").execute(request,response);
        }

        UserDao userDao = new UserSqlDao();

        if (request.getParameter("email") == null) {
            return "login";
        }
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");

        try {
            user = userDao.findByEmailAndPassword(email, PasswordHashing.hashPassword(password));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (user == null) {
            request.getSession().setAttribute("loginMessage","index.login.error");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        final Logger logger = Logger.getLogger(LoginAction.class);
        logger.error("New sql exception",new SQLException());
        logger.info("something useless happened");


        return CommandFactory.defineCommand("/seances").execute(request,response);
    }
}
