package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.FilmGenre;

import java.sql.ResultSet;

public interface FilmGenreDao {
    FilmGenre findFilmGenreByName(String name) throws DaoException;

    FilmGenre findFilmGenreById(int id) throws DaoException;

    void createFilmGenre(FilmGenre filmGenre)throws DaoException;

    void deleteFilmGenre(int id)throws DaoException;

    FilmGenre extractFromResultSet(ResultSet resultSet)throws DaoException;

}
