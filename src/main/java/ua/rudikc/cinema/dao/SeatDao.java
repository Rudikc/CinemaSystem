package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Seat;

import java.sql.ResultSet;
import java.util.List;

public interface SeatDao {
    Seat findSeatById(int id) throws DaoException;

    List<Seat> findAllSeats() throws DaoException;

    void createSeat(Seat seat) throws DaoException;

    void deleteSeat(int id) throws DaoException;

    Seat extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
