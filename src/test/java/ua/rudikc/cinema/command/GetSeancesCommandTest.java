package ua.rudikc.cinema.command;

import org.junit.Test;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.Film;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GetSessionsCommandTest {

    @Test
    public void execute() throws DaoException {
        FilmSqlDao dao = (FilmSqlDao) DaoFactory.getDao("filmDao");
        ArrayList<Film> films = dao.findActualFilms();
        if (films.isEmpty()){
            System.out.println("Hi");
        }
        for (Film film : films) {
            System.out.println(film);
        }
    }
}