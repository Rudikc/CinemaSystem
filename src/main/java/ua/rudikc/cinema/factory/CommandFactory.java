package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.command.GetSeancesCommand;
import ua.rudikc.cinema.command.HomeCommand;
import ua.rudikc.cinema.command.profile.LoginCommand;
import ua.rudikc.cinema.command.profile.LogoutCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("/login",new LoginCommand());
        commands.put("/logout",new LogoutCommand());
        commands.put("/",new HomeCommand());
        commands.put("/seances",new GetSeancesCommand());

    }

    public static Command defineCommand(HttpServletRequest request) {
        return commands.getOrDefault(request.getPathInfo(), new HomeCommand());

    }
}
