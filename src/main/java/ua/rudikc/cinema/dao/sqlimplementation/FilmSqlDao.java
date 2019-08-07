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

import static ua.rudikc.cinema.utils.Constants.*;

public class FilmSqlDao implements FilmDao {

    Logger logger = Logger.getLogger(FilmSqlDao.class);



    private static final String SELECT_BY_ID = "SELECT * FROM cinema_db.films WHERE film_id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM cinema_db.films WHERE film_name = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.film_genres WHERE film_genre_id = ?";
    private final static String UPDATE_FILM = "UPDATE cinema_db.films SET name=?,imbd_rating=?,director=?,premiere_date=?,budget_$=?,duration=?,poster_pic=? WHERE film_id =?";
    private final static String INSERT_FILM = "INSERT INTO cinema_db.films (name,imbd_rating,director,premiere_date,budget_$,duration,poster_pic) VALUES (?,?,?,?,?,?,?)";


    @Override
    public Film findFilmById(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Film findFilmByName(String name) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createFilm(Film film) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_FILM);
            preparedStatement.setString(1,film.getName());
            preparedStatement.setDouble(2,film.getImbdRating());
            preparedStatement.setString(3,film.getDirector());
            preparedStatement.setDate(4, (Date) film.getPremiereDate());
            preparedStatement.setDouble(5,film.getBudget());
            preparedStatement.setDate(6,film.getDuration());
            preparedStatement.setString(7,film.getPosterPic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteFilm(int id) throws DaoException {

    }

    @Override
    public void updateFilm(Film film) throws DaoException {

    }

    @Override
    public Film extractFromResultSet(ResultSet resultSet) {
        Film film = new Film();
        try {
            film.setId(resultSet.getInt(FILM_ID));
            film.setBudget((long) resultSet.getDouble(FILM_BUDGET_$));
            film.setDirector(resultSet.getString(FILM_director));
            film.setDuration(resultSet.getDate(FILM_DURATION));
            film.setImbdRating(resultSet.getDouble(FILM_IMDB_RATING));
            film.setPosterPic(resultSet.getString(FILM_POSTER_PIC));
            film.setName(resultSet.getString(FILM_NAME));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
}
