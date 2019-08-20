package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.FilmGenre;

import java.sql.ResultSet;
import java.util.Optional;

public interface FilmGenreDao extends Dao<FilmGenre> {
    Optional<FilmGenre> findFilmGenreByName(String name) throws DaoException;

    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    FilmGenre extractFromResultSet(ResultSet resultSet) throws DaoException;
}
