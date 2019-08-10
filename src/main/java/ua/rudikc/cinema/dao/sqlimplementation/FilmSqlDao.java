package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.FilmDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Film;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class FilmSqlDao implements FilmDao {

    Logger logger = Logger.getLogger(FilmSqlDao.class);

    private static final String SELECT_ALL_ACTUAL_FILMS = "SELECT * FROM cinema_db.films WHERE is_actual = 1";
    private static final String SELECT_BY_ID = "SELECT * FROM cinema_db.films WHERE film_id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM cinema_db.films WHERE film_name = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.film_genres WHERE film_genre_id = ?";
    private final static String UPDATE_FILM = "UPDATE cinema_db.films SET film_name=?,director=?,premiere_date=?,duration=?,poster_pic=? WHERE film_id =?";
    private final static String INSERT_FILM = "INSERT INTO cinema_db.films (film_name,director,premiere_date,duration,poster_pic) VALUES (?,?,?,?,?)";


    @Override
    public Film findFilmById(int id) throws DaoException {
        Film film = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = extractFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public Film findFilmByName(String name) throws DaoException {
        Film film = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = extractFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void createFilm(Film film) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_FILM);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.setDate(3, (Date) film.getPremiereDate());
            preparedStatement.setTime(4, film.getDuration());
            preparedStatement.setString(5, film.getPosterPic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFilm(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateFilm(Film film) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_FILM);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.setDate(3, (Date) film.getPremiereDate());
            preparedStatement.setTime(4, film.getDuration());
            preparedStatement.setString(5, film.getPosterPic());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Film> findActualFilms() throws DaoException {
        ArrayList<Film> resultFilms = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_ACTUAL_FILMS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultFilms.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultFilms;
    }

    @Override
    public Film extractFromResultSet(ResultSet resultSet) {
        Film film = new Film();
        try {
            film.setId(resultSet.getInt(FILM_ID));
            film.setDirector(resultSet.getString(FILM_director));
            film.setDuration(resultSet.getTime(FILM_DURATION));
            film.setPosterPic(resultSet.getString(FILM_POSTER_PIC));
            film.setName(resultSet.getString(FILM_NAME));
            film.setPremiereDate(resultSet.getDate(FILM_PREMIERE_DATE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
}
