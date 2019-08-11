package ua.rudikc.cinema.command.profile;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.User;
import ua.rudikc.cinema.utils.AuthorizationHelper;
import ua.rudikc.cinema.utils.PassowordHashing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserDao dao = (UserDao) DaoFactory.getDao("userDao");
        User user;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone = request.getParameter("phone");

        if (first_name == null || email == null || password == null){
            return "register";
        }
        if (AuthorizationHelper.isEmailCorrect(email) && AuthorizationHelper.isPasswordCorrect(password)) {
            String passwordHash = PassowordHashing.hashPassword(password);
            user = new User(passwordHash, email, first_name, last_name, phone);
        }else {
            request.getSession().setAttribute("registrationMessage","registration.data.failure");
            return "register";
        }
        try {
            dao.createUser(user);
            request.getSession().setAttribute("loginMessage","login.registration.success");
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "login";
    }
}
