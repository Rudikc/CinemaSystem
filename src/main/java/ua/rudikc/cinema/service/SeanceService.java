package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.entity.Seance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SeanceService {

    public List<Seance> setFilmsForSeances(List<Seance> seances) {
        FilmSqlDao filmDao = (FilmSqlDao) DaoFactory.getDao("filmDao");
        List<Seance> seancesResult = new ArrayList<>();
        for (Seance seance : seances) {
            int filmId = seance.getFilm().getId();
            try {
                filmDao.get(filmId).ifPresent(seance::setFilm);
                seancesResult.add(seance);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        return seancesResult;
    }
}
