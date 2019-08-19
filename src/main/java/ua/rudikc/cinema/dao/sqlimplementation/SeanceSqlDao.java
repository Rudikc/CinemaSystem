package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.entity.Seance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;

public class SeanceSqlDao implements SeanceDao {

    private static final Logger logger = Logger.getLogger(SeanceSqlDao.class);

    @Override
    public Optional<Seance> get(int id) throws DaoException {
        Optional<Seance> seance = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SEANCE.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find a seance by id ", e);
            throw new DaoException();
        }
        return seance;
    }

    @Override
    public List<Seance> getAll() throws DaoException {
        List<Seance> seances = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SEANCES.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seances.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seances;
    }

    @Override
    public void update(Seance seance) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEANCE.getQuery());
            preparedStatement.setTimestamp(1, (Timestamp) seance.getStart());
            preparedStatement.setTimestamp(2, (Timestamp) seance.getEnd());
            preparedStatement.setInt(3, seance.getFilm());
            preparedStatement.setDouble(4, seance.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to update a seance ", e);
            throw new DaoException();
        }
    }

    @Override
    public void save(Seance seance) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEANCE.getQuery());
            preparedStatement.setObject(1,  seance.getStart());
            preparedStatement.setObject(2,  seance.getEnd());
            preparedStatement.setInt(3, seance.getFilm());
            preparedStatement.setDouble(4, seance.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a seance ", e);
            throw new DaoException();
        }

    }

    @Override
    public void delete(Seance seance) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SEANCE.getQuery());
            preparedStatement.setInt(1, seance.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a seance ", e);
            throw new DaoException("Seance cant be deleted");
        }
    }

    @Override
    public List<Seance> findSeancesByDate(String date) throws DaoException {
        ArrayList<Seance> seances = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SEANCES_BY_DATE.getQuery());
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seances.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seances;
    }

    @Override
    public Seance extractFromResultSet(ResultSet resultSet) throws DaoException {
        Seance seance = new Seance();
        Film film = new Film();
        try {
            seance.setId(resultSet.getInt(SEANCE_ID));
            seance.setStart(resultSet.getTimestamp(SEANCE_START));
            seance.setEnd(resultSet.getTimestamp(SEANCE_END));
            seance.setFilm(resultSet.getInt(SEANCE_FILM_ID));
            seance.setPrice(resultSet.getDouble(SEANCE_TICKET_PRICE));

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a seance from result set ", e);
            throw new DaoException();
        }
        return seance;
    }
}
