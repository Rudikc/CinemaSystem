package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.command.HomeCommand;
import ua.rudikc.cinema.command.LoginCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("login",new LoginCommand());
        commands.put("",new HomeCommand());

    }

    public static Command defineCommand(String command) {
        return commands.getOrDefault(command, new HomeCommand());

    }
}
