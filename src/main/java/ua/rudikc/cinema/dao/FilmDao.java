package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Film;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface FilmDao extends Dao<Film> {
    /**
     * Finds film entity by name
     * @param name - film name
     * @return film entity
     * @throws DaoException
     */
    Optional<Film> findFilmByName(String name) throws DaoException;

    /**
     * Finds all actual films
     * @return list of films that are actual
     * @throws DaoException
     */
    List<Film> findActualFilms() throws DaoException;

    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    Film extractFromResultSet(ResultSet resultSet);
}
