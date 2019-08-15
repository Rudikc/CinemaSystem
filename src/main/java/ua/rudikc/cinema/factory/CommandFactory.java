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
        commands.put("/purchase-ticket",new PurchaseTicketAction());
        commands.put("/purchase-confirm",new TicketPurchaseConfirmAction());
    }

    public static Action defineCommand(String path) {
        return commands.getOrDefault(path,new Error404Action());

    }
}
