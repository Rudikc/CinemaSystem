package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.FilmDao;
import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.SeanceSqlDao;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.entity.Seance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.factory.DaoFactory.FILM_DAO;

public class SeanceService {


    public List<SeanceDto> getSeancesByDate(String date) {
        SeanceSqlDao seanceDao = (SeanceSqlDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        List<SeanceDto> dtoSeances = new ArrayList<>();
        try {
            List<Seance> seances = seanceDao.findSeancesByDate(date);
            for (Seance seance : seances) {
                dtoSeances.add(getSeanceDtoById(seance.getId()));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return dtoSeances;
    }

    public SeanceDto getSeanceDtoById(int seanceId) {
        SeanceSqlDao seanceSqlDao = (SeanceSqlDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(FILM_DAO);
        SeanceDto seanceDto = new SeanceDto();
        try {
            Optional<Seance> seanceEntity = seanceSqlDao.get(seanceId);
            if (seanceEntity.isPresent()) {
                seanceDto = new SeanceDto(seanceEntity.get());
                filmSqlDao.get(seanceEntity.get().getFilm().getId()).ifPresent(seanceDto::setFilm);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return seanceDto;
    }

    public List<Seance> setFilmsForSeances(List<Seance> seances) {
        FilmSqlDao filmDao = (FilmSqlDao) DaoFactory.getDao(FILM_DAO);
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
