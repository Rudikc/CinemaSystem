package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeatTypeDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
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

public class SeatTypeSqlDao implements SeatTypeDao {

    Logger logger = Logger.getLogger(SeatTypeSqlDao.class);

    @Override
    public void save(SeatType seatType) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEAT_TYPE.getQuery());
            preparedStatement.setString(1, seatType.getType());
            preparedStatement.setDouble(2, seatType.getPriceMultiplier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(SeatType seatType) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEAT_TYPE.getQuery());
            preparedStatement.setString(1, seatType.getType());
            preparedStatement.setDouble(2, seatType.getPriceMultiplier());
            preparedStatement.setInt(3, seatType.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(SeatType seatType) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SEAT_TYPE.getQuery());
            preparedStatement.setInt(1, seatType.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<SeatType> get(int id) throws DaoException {
        Optional<SeatType> seatType = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SEAT_TYPE.getQuery());
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seatType = Optional.of(extractSeatFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatType;
    }

    @Override
    public List<SeatType> getAll() throws DaoException {
        ArrayList<SeatType> seatTypes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SEAT_TYPES.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seatTypes.add(extractSeatFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatTypes;
    }

    @Override
    public SeatType extractSeatFromResultSet(ResultSet resultSet) throws DaoException {
        SeatType seatType = new SeatType();
        try {
            seatType.setId(resultSet.getInt(SEAT_TYPE_ID));
            seatType.setPriceMultiplier(resultSet.getDouble(SEAT_TYPE_PRICE_MULTIPLIER));
            seatType.setType(resultSet.getString(SEAT_TYPE_TYPE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatType;
    }
}
