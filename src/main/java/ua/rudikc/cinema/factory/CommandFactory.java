package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.controller.actions.*;
import ua.rudikc.cinema.controller.actions.HomeAction;
import ua.rudikc.cinema.controller.actions.films.AddFilmAction;
import ua.rudikc.cinema.controller.actions.films.GetFilmCatalogueAction;
import ua.rudikc.cinema.controller.actions.films.RemoveFilmAction;
import ua.rudikc.cinema.controller.actions.order.RemoveOrderAction;
import ua.rudikc.cinema.controller.actions.profile.GetUserProfileAction;
import ua.rudikc.cinema.controller.actions.profile.LoginAction;
import ua.rudikc.cinema.controller.actions.profile.LogoutAction;
import ua.rudikc.cinema.controller.actions.profile.RegisterAction;
import ua.rudikc.cinema.controller.actions.seance.AddSeanceAction;
import ua.rudikc.cinema.controller.actions.seance.GetSeancesAction;
import ua.rudikc.cinema.controller.actions.seance.RemoveSeanceAction;
import ua.rudikc.cinema.controller.actions.seats.GetSeatsMapAction;
import ua.rudikc.cinema.controller.actions.ticket.PurchaseTicketAction;
import ua.rudikc.cinema.controller.actions.ticket.TicketPurchaseConfirmAction;
import ua.rudikc.cinema.controller.actions.utils.ChangeLanguageAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory of commands for dispatcher servlet
 */
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
        commands.put("/remove-order",new RemoveOrderAction());
        commands.put("/remove-seance",new RemoveSeanceAction());
        commands.put("/add-seance",new AddSeanceAction());
        commands.put("/film-catalogue",new GetFilmCatalogueAction());
        commands.put("/add-film", new AddFilmAction());
        commands.put("/remove-film",new RemoveFilmAction());
    }

    /**
     * Defining the uri and gives right action for dispatcher servlet
     *
     * @param path servlet uri
     * @return action
     */
    public static Action defineCommand(String path) {
        return commands.getOrDefault(path,new Error404Action());

    }
}
