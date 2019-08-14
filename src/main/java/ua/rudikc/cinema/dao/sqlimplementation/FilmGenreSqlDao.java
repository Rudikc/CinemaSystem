package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.FilmGenreDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.FilmGenre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.FILM_GENRE_ID;
import static ua.rudikc.cinema.utils.Constants.FILM_GENRE_NAME;

public class FilmGenreSqlDao implements FilmGenreDao {

    private static final Logger logger = Logger.getLogger(FilmGenreSqlDao.class);

    @Override
    public Optional<FilmGenre> get(int id) {
        Optional<FilmGenre> filmGenre = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILM_GENRE.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                filmGenre = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }

    @Override
    public List<FilmGenre> getAll() throws DaoException {
        List<FilmGenre> filmGenres = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FILM_GENRES.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                filmGenres.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenres;
    }

    @Override
    public void save(FilmGenre filmGenre) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILM_GENRE.getQuery());
            preparedStatement.setString(1, filmGenre.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FilmGenre filmGenre) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FILM_GENRE.getQuery());
            preparedStatement.setString(1, filmGenre.getName());
            preparedStatement.setInt(2, filmGenre.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(FilmGenre filmGenre) {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FILM_GENRE.getQuery());
            preparedStatement.setInt(1, filmGenre.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FilmGenre> findFilmGenreByName(String name) {
        Optional<FilmGenre> filmGenre = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILM_GENRE_BY_NAME.getQuery());
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                filmGenre = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }

    @Override
    public FilmGenre extractFromResultSet(ResultSet resultSet) {
        FilmGenre filmGenre = new FilmGenre();
        try {
            filmGenre.setId(resultSet.getInt(FILM_GENRE_ID));
            filmGenre.setName(resultSet.getString(FILM_GENRE_NAME));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmGenre;
    }
}
