package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.SeatType;

import java.sql.ResultSet;

public interface SeatTypeDao extends Dao<SeatType> {
    SeatType extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
