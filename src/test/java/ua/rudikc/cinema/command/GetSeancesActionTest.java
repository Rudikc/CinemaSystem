package ua.rudikc.cinema.command;

import org.junit.Test;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.entity.Film;

import static org.junit.Assert.*;

public class GetSeancesActionTest {

    @Test
    public void execute() throws DaoException {
        FilmSqlDao dao = (FilmSqlDao) DaoFactory.getDao("filmDao");
        Film film = dao.get(1).orElse(null);
        assertEquals(1, film.getId());
    }
}