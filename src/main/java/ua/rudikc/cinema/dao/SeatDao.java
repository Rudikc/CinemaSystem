package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Seat;

import java.sql.ResultSet;
import java.util.List;

public interface SeatDao extends Dao<Seat> {
    Seat extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
