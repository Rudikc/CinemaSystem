package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.entity.Seance;
import ua.rudikc.cinema.service.SeanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSeancesAction implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        List<SeanceDto> seances = seanceService.getSeancesByDate("2019-08-12");
        request.setAttribute("seances", seances);
        return "seances";
    }

}
