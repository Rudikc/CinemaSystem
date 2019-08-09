package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeatTypeDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.SeatType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class SeatTypeSqlDao implements SeatTypeDao {

    Logger logger = Logger.getLogger(SeatTypeSqlDao.class);

    private static final String SELECT_ALL_TYPES = "SELECT * FROM cinema_db.seat_types";
    private static final String SELECT_BY_ID = "SELECT * FROM cinema_db.seat_types WHERE seat_type_id=?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.seat_types WHERE seat_type_id = ?";
    private static final String INSERT_SEAT_TYPE = "INSERT INTO  cinema_db.seat_types (seat_type,price_multiplier) VALUES (?,?)";


    @Override
    public void createSeatType(SeatType seatType) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_SEAT_TYPE);
            preparedStatement.setString(1, seatType.getType());
            preparedStatement.setDouble(2, seatType.getPriceMultiplier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSeatType(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SeatType findSeatTypeById(int id) throws DaoException {
        SeatType seatType = new SeatType();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seatType = extractSeatFromResultSet(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatType;
    }

    @Override
    public List<SeatType> findAllSeatTypes() throws DaoException {
        ArrayList<SeatType> seatTypes = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_TYPES);
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
