package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.FilmGenreDao;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.FilmGenre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.rudikc.cinema.utils.Constants.FILM_GENRE_ID;
import static ua.rudikc.cinema.utils.Constants.FILM_GENRE_NAME;

public class FilmGenreSqlDao implements FilmGenreDao {

    Logger logger = Logger.getLogger(FilmGenreSqlDao.class);

    private static final String SELECT_BY_ID = "SELECT * FROM cinema_db.film_genres WHERE film_genre_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.film_genres WHERE film_genre_id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM cinema_db.film_genres WHERE film_genre_name = ?";
    private static final String INSERT_FILM_GENRE = "INSERT INTO cinema_db.film_genres (name) VALUES (?)";


    @Override
    public FilmGenre findFilmGenreByName(String name) {
        FilmGenre filmGenre = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                filmGenre = extractFromResultSet(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }

    @Override
    public FilmGenre findFilmGenreById(int id) {
        FilmGenre filmGenre = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                filmGenre = extractFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }

    @Override
    public void createFilmGenre(FilmGenre filmGenre) {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_FILM_GENRE);
            preparedStatement.setString(1,filmGenre.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFilmGenre(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FilmGenre extractFromResultSet(ResultSet resultSet) {
        FilmGenre filmGenre = null;
        try {
            filmGenre.setId(resultSet.getInt(FILM_GENRE_ID));
            filmGenre.setName(resultSet.getString(FILM_GENRE_NAME));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }
}
