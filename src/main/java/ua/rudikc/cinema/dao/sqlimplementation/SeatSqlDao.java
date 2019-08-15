package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeatDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Seat;
import ua.rudikc.cinema.entity.SeatType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;

public class SeatSqlDao implements SeatDao {

    private static final Logger logger = Logger.getLogger(Seat.class);

    @Override
    public Optional<Seat> get(int id) throws DaoException {
        Optional<Seat> seat = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SEAT.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seat = Optional.of(extractSeatFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seat;
    }

    @Override
    public List<Seat> getAll() throws DaoException {
        List<Seat> seats = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SEATS.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seats.add(extractSeatFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find all seats ", e);
            throw new DaoException();
        }
        return seats;
    }

    @Override
    public void save(Seat seat) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEAT.getQuery());
            preparedStatement.setInt(1, seat.getRow());
            preparedStatement.setInt(2, seat.getPlace());
            preparedStatement.setInt(3, seat.getSeatTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a seat ", e);
            throw new DaoException();
        }
    }

    @Override
    public void update(Seat seat) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEAT.getQuery());
            preparedStatement.setInt(1, seat.getRow());
            preparedStatement.setInt(2, seat.getPlace());
            preparedStatement.setInt(3, seat.getSeatTypeId());
            preparedStatement.setInt(4, seat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Seat seat) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SEAT.getQuery());
            preparedStatement.setInt(1, seat.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a seat ", e);
            throw new DaoException();
        }
    }

    @Override
    public Seat extractSeatFromResultSet(ResultSet resultSet) throws DaoException {
        Seat seat = new Seat();

        try {
            seat.setId(resultSet.getInt(SEAT_ID));
            seat.setPlace(resultSet.getInt(SEAT_PLACE));
            seat.setRow(resultSet.getInt(SEAT_ROW));
            seat.setSeatTypeId(resultSet.getInt(SEAT_SEAT_TYPE_ID));
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a seat from result set ", e);
            throw new DaoException();
        }
        return seat;
    }
}
