package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Ticket;

import java.sql.ResultSet;
import java.util.List;

public interface TicketDao extends Dao<Ticket> {
    /**
     * Finding all tickets by seance id
     * @param id seance id
     * @return list of tickets
     * @throws DaoException
     */
    List<Ticket> findAllTicketsBySessionId(int id) throws DaoException;

    /**
     * Finding all tickets by order id
     * @param id - order id
     * @return list of ticket entities
     * @throws DaoException
     */
    List<Ticket> findTicketsByOrderId(int id) throws DaoException;

    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    Ticket extractFromResultSet(ResultSet resultSet) throws DaoException;
}
