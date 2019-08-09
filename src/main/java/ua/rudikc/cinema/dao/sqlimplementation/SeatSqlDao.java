package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeatDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Seat;
import ua.rudikc.cinema.model.SeatType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class SeatSqlDao implements SeatDao {

    Logger logger = Logger.getLogger(Seat.class);

    private static final String SELECT_ALL_SEATS = "SELECT * FROM cinema_db.seats";
    private static final String SELECT_SEAT_BY_ID = "SELECT * FROM cinema_db.seats WHERE seat_id =?";
    private static final String DELETE_SEAT_BY_ID = "DELETE FROM cinema_db.seats WHERE seat_id =?";
    private static final String INSERT_SEAT = "INSERT INTO cinema_db.seats(seat_row,seat_place,seat_type_id) VALUES(?,?,?)";


    @Override
    public Seat findSeatById(int id) throws DaoException {
        Seat seat = new Seat();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_SEAT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                seat = extractSeatFromResultSet(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seat;
    }

    @Override
    public List<Seat> findAllSeats() throws DaoException {
        List<Seat> seats = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ALL_SEATS);
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
    public void createSeat(Seat seat) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_SEAT);
            preparedStatement.setInt(1, seat.getRow());
            preparedStatement.setInt(2, seat.getPlace());
            preparedStatement.setInt(3, seat.getSeatType().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a seat ", e);
            throw new DaoException();
        }
    }

    @Override
    public void deleteSeat(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_SEAT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a seat ", e);
            throw new DaoException();
        }
    }

    @Override
    public Seat extractSeatFromResultSet(ResultSet resultSet) throws DaoException {
        Seat seat = new Seat();
        SeatType seatType = new SeatType();

        try {
            seat.setId(resultSet.getInt(SEAT_ID));
            seat.setPlace(resultSet.getInt(SEAT_PLACE));
            seat.setRow(resultSet.getInt(SEAT_ROW));
            seatType.setId(resultSet.getInt(SEAT_SEAT_TYPE_ID));
            seat.setSeatType(seatType);
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a seat from result set ", e);
            throw new DaoException();
        }
        return seat;
    }
}
