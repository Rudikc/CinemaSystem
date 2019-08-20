package ua.rudikc.cinema.listener;

import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session listener that sets user role to guest.
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        User user = new User();
        user.setRole(UserRole.GUEST);
        httpSessionEvent.getSession().setAttribute("user",user);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }
}
