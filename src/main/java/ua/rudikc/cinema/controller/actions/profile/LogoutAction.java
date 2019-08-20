package ua.rudikc.cinema.controller.actions.profile;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {
    /**
     * Action for users logout.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user", null);
        User user = new User();
        user.setRole(UserRole.GUEST);
        request.getSession().setAttribute("user", user);
        return "index";
    }
}
