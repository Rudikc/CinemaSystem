package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Film;

import java.sql.ResultSet;

public interface FilmDao {
    Film findFilmById(int id) throws DaoException;

    Film findFilmByName(String name) throws DaoException;

    void createFilm(Film film) throws DaoException;

    void deleteFilm(int id) throws DaoException;

    void updateFilm(Film film) throws DaoException;

    Film extractFromResultSet(ResultSet resultSet);

}
