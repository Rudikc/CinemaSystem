package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.command.GetTitlesCommand;
import ua.rudikc.cinema.command.HomeCommand;
import ua.rudikc.cinema.command.LoginCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("login",new LoginCommand());
        commands.put("",new HomeCommand());
        commands.put("titles",new GetTitlesCommand());

    }

    public static Command defineCommand(String command) {
        return commands.getOrDefault(command, new HomeCommand());

    }
}
