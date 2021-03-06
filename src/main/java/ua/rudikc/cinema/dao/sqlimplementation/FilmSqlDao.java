package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.FilmDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;

public class FilmSqlDao implements FilmDao {

    private static final Logger logger = Logger.getLogger(FilmSqlDao.class);


    @Override
    public Optional<Film> get(int id) throws DaoException {
        Optional<Film> film = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILM.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public List<Film> getAll() throws DaoException {
        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FILMS.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                films.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public void save(Film film) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILM.getQuery());
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.setObject(3, film.getPremiereDate());
            preparedStatement.setObject(4, film.getDuration());
            preparedStatement.setString(5, film.getPosterPic());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Film film) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FILM.getQuery());
            preparedStatement.setInt(1, film.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Film film) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FILM.getQuery());
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDirector());
            preparedStatement.setObject(3, film.getPremiereDate());
            preparedStatement.setObject(4, film.getDuration());
            preparedStatement.setString(5, film.getPosterPic());
            preparedStatement.setInt(6, film.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Film> findFilmByName(String name) {
        Optional<Film> film = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILM_BY_NAME.getQuery());
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public List<Film> findActualFilms() throws DaoException {
        ArrayList<Film> resultFilms = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ACTUAL_FILMS.getQuery());
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

    public List<Film> paginationGet(int low, int upper) {
        List<Film> resultFilms = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILMS_PAGINATION.getQuery());
            preparedStatement.setInt(1, low);
            preparedStatement.setInt(2, upper);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultFilms.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultFilms;
    }

    public Integer countFilms() {
        int count = 0;
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_FILMS_COUNT.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Film extractFromResultSet(ResultSet resultSet) {
        Film film = new Film();
        try {
            film.setId(resultSet.getInt(FILM_ID));
            film.setDirector(resultSet.getString(FILM_director));
            film.setDuration(resultSet.getTime(FILM_DURATION).toLocalTime());
            film.setPosterPic(resultSet.getString(FILM_POSTER_PIC));
            film.setName(resultSet.getString(FILM_NAME));
            film.setPremiereDate(resultSet.getDate(FILM_PREMIERE_DATE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
}
