package ua.rudikc.cinema.controller.actions.films;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.CommandFactory;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.FilmService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddFilmAction implements Action {

    /**
     * Action to add a new film.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        FilmService filmService = (FilmService) ServiceFactory.getService("filmService");

        try {
            String duration = request.getParameter("duration");
            String name = request.getParameter("film-name");
            Date premiereDate = simpleDateFormat.parse(request.getParameter("premiere-date"));
            String director = request.getParameter("director");
            String posterPic = request.getParameter("poster-pic");

            Film film = Film
                    .newBuilder()
                    .setDate(premiereDate)
                    .setDirector(director)
                    .setDuration(duration)
                    .setName(name)
                    .setPosterPic(posterPic)
                    .build();

            filmService.addFilm(film);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return CommandFactory.defineCommand("/film-catalogue").execute(request, response);
    }
}
