package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Seat;

import java.sql.ResultSet;

public interface SeatDao extends Dao<Seat> {
    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    Seat extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
