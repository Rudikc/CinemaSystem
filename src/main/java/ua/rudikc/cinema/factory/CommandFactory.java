package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.controller.actions.*;
import ua.rudikc.cinema.controller.actions.profile.GetUserProfileAction;
import ua.rudikc.cinema.controller.actions.profile.LoginAction;
import ua.rudikc.cinema.controller.actions.profile.LogoutAction;
import ua.rudikc.cinema.controller.actions.profile.RegisterAction;
import ua.rudikc.cinema.controller.actions.utils.ChangeLanguageAction;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Action> commands;

    static {
        commands = new HashMap<>();
        commands.put("/",new HomeAction());
        commands.put("/login",new LoginAction());
        commands.put("/logout",new LogoutAction());
        commands.put("/seances",new GetSeancesAction());
        commands.put("/changeLanguage",new ChangeLanguageAction());
        commands.put("/register",new RegisterAction());
        commands.put("/seats",new GetSeatsMapAction());
        commands.put("/user-profile",new GetUserProfileAction());

    }

    public static Action defineCommand(HttpServletRequest request) {
        return commands.getOrDefault(request.getPathInfo(),new Error404Action());

    }
}
