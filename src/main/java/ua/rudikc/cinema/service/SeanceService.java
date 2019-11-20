package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.SeanceSqlDao;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.entity.Seance;

import java.util.*;

import static ua.rudikc.cinema.factory.DaoFactory.FILM_DAO;

/**
 * Seance service for for with seance
 */
public class SeanceService {


    private static final Comparator<SeanceDto> TIME_ORDER = Comparator.comparing(SeanceDto::getStart);

    /**
     * Adds and order to database
     * @param user
     * @param seance
     */
    public void addSeance(User user, Seance seance){
        SeanceDao seanceDao = (SeanceDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        if (user.getRole() == UserRole.ADMIN){
            try {
                seanceDao.save(seance);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a list of seances by given date
     * @param date
     * @return list of seances
     */
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
        dtoSeances.sort(TIME_ORDER);
        return dtoSeances;
    }

    /**
     * Returning seance dto by id
     * @param seanceId
     * @return seanceDto
     */
    public SeanceDto getSeanceDtoById(int seanceId) {
        SeanceSqlDao seanceSqlDao = (SeanceSqlDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(FILM_DAO);
        SeanceDto seanceDto = new SeanceDto();
        try {
            Optional<Seance> seanceEntity = seanceSqlDao.get(seanceId);
            if (seanceEntity.isPresent()) {
                seanceDto = new SeanceDto(seanceEntity.get());
                filmSqlDao.get(seanceEntity.get().getFilm()).ifPresent(seanceDto::setFilm);
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
            int filmId = seance.getFilm();
            try {
                filmDao.get(filmId).ifPresent(film -> {seance.setFilm(film.getId());});
                seancesResult.add(seance);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        return seancesResult;
    }

    /**
     * Removes seance from database
     * @param seanceId
     */
    public void removeSeance(int seanceId){
        SeanceSqlDao seanceSqlDao = (SeanceSqlDao) DaoFactory.getDao(DaoFactory.SEANCE_DAO);
        try {
            Optional<Seance> seance = seanceSqlDao.get(seanceId);
            if (seance.isPresent()) {
                seanceSqlDao.delete(seance.get());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
