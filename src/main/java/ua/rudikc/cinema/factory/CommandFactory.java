package ua.rudikc.cinema.factory;

import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.command.LoginCommand;

public class CommandFactory {



    public static Command getCommand(){


        return new LoginCommand();
    }
}
