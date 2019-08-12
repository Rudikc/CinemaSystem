package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Film;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface FilmDao extends Dao<Film> {
    Optional<Film> findFilmByName(String name) throws DaoException;

    List<Film> findActualFilms() throws DaoException;

    Film extractFromResultSet(ResultSet resultSet);
}
