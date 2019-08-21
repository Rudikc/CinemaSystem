package ua.rudikc.cinema.controller.actions.films;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.FilmService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetFilmCatalogueAction implements Action {
    /**
     * Action that return catalogue of films for admin.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRole() != UserRole.ADMIN) {
            return "index";
        }
        FilmService filmService = (FilmService) ServiceFactory.getService("filmService");

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int itemsPerPage = 2;

        List<Film> films = filmService.getFilmsPagination(page, itemsPerPage);
        List<Integer> pages = filmService.getFilmsMaxPages(itemsPerPage);

        request.setAttribute("films", films);
        request.setAttribute("pages", pages);

        return "film-catalogue";
    }
}
