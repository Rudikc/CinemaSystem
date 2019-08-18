package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.SeanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSeancesAction implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        String givenDate = request.getParameter("given-date");
        List<SeanceDto> seances = seanceService.getSeancesByDate(givenDate);
        request.setAttribute("seances", seances);
        return "seances";
    }

}
