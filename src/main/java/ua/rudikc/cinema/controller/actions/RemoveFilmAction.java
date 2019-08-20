package ua.rudikc.cinema.controller.actions;

import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.FilmService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveFilmAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        FilmService filmService = (FilmService) ServiceFactory.getService("filmService");
        User user = (User) request.getSession().getAttribute("user");
        Film film = Film.newBuilder()
                .setId(Integer.parseInt(request.getParameter("film-id")))
                .build();

        if (user.getRole() == UserRole.ADMIN){
            filmService.removeFilm(film);
        }
        return CommandFactory.defineCommand("/film-catalogue").execute(request,response);
    }
}
