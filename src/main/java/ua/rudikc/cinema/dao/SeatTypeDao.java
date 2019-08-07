package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Seat;
import ua.rudikc.cinema.model.SeatType;

import java.sql.ResultSet;
import java.util.List;

public interface SeatTypeDao {

    void createSeatType(SeatType seatType) throws DaoException;

    void deleteSeatType(int id) throws DaoException;

    SeatType findSeatTypeById(int id) throws DaoException;

    List<SeatType> findAllSeatTypes() throws DaoException;

    SeatType extractSeatFromResultSet(ResultSet resultSet) throws DaoException;
}
