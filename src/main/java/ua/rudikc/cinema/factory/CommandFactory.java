package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.command.LoginCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("/login",new LoginCommand());

    }

    public static Command getCommand(HttpServletRequest req) {
        String actionPath = req.getPathInfo();
        return commands.get(actionPath);
    }
}
