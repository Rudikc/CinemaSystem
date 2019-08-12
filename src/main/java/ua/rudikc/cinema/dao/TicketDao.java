package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Ticket;

import java.sql.ResultSet;
import java.util.List;

public interface TicketDao extends Dao<Ticket> {
    List<Ticket> findAllTicketsBySessionId(int id) throws DaoException;

    List<Ticket> findTicketsByOrderId(int id) throws DaoException;

    Ticket extractFromResultSet(ResultSet resultSet) throws DaoException;
}
