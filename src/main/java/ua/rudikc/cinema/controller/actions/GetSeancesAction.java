package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.FilmService;
import ua.rudikc.cinema.service.SeanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetSeancesAction implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        FilmService filmService = (FilmService) ServiceFactory.getService("filmService");

        List<SeanceDto> seances = seanceService.getSeancesByDate(request.getParameter("given-date"));
        List<Film> allFilms = filmService.getAllFilms();

        request.setAttribute("date",request.getParameter("given-date"));
        request.setAttribute("allFilms",allFilms);
        request.setAttribute("seances", seances);
        return "seances";
    }

}
