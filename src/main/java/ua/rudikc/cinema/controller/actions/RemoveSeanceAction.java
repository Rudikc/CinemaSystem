package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.SeanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveSeanceAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        User user = (User) request.getSession().getAttribute("user");
        int seanceId = Integer.parseInt(request.getParameter("seance-id"));
        if (user.getRole() == UserRole.ADMIN){
            seanceService.removeSeance(seanceId);
        }

        return CommandFactory.defineCommand("/seances").execute(request,response);
    }
}
