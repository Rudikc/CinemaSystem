package ua.rudikc.cinema.command;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.Film;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetTitlesCommand implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        FilmSqlDao dao = (FilmSqlDao) DaoFactory.getDao("filmDao");
        try {
            ArrayList<Film> films = dao.findActualFilms();
            request.setAttribute("films",films);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "titles";
    }
}
