package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Seat;
import ua.rudikc.cinema.model.SeatType;

import java.sql.ResultSet;
import java.util.List;

public interface SeatTypeDao extends Dao<SeatType> {
    SeatType extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
