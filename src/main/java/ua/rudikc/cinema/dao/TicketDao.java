package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Ticket;

import java.sql.ResultSet;
import java.util.List;

public interface TicketDao {
    List<Ticket> findAllTicketsBySessionId(int id) throws DaoException;

    List<Ticket> findTicketsByOrderId(int id) throws DaoException;

    Ticket findTicketById(int id) throws DaoException;

    void createTicket(Ticket ticket) throws DaoException;

    void deleteTicketById(int id) throws DaoException;

    Ticket extractFromResultSet(ResultSet resultSet) throws DaoException;
}
