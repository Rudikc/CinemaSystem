package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.FilmGenre;

import java.sql.ResultSet;
import java.util.Optional;

public interface FilmGenreDao extends Dao<FilmGenre> {
    Optional<FilmGenre> findFilmGenreByName(String name) throws DaoException;

    FilmGenre extractFromResultSet(ResultSet resultSet) throws DaoException;
}
