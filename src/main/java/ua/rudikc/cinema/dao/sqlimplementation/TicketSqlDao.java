package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.TicketDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Order;
import ua.rudikc.cinema.model.Session;
import ua.rudikc.cinema.model.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class TicketSqlDao implements TicketDao {

    Logger logger = Logger.getLogger(TicketSqlDao.class);

    private static final String FIND_ALL_BY_SESSION_ID = "SELECT * FROM cinema_db.tickets WHERE session_id = ?";
    private static final String FIND_ALL_BY_ORDER_ID = "SELECT * FROM cinema_db.tickets WHERE order_id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM cinema_db.tickets WHERE order_id = ?";
    private static final String INSERT_TICKET = "INSERT INTO cinema_db.tickets (seat_id,order_id,session_id) VALUES (?,?,?)";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.tickets WHERE ticket_id=?";


    @Override
    public List<Ticket> findAllTicketsBySessionId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_ALL_BY_SESSION_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find tickets by session id", e);
            throw new DaoException();
        }
        return tickets;
    }

    @Override
    public List<Ticket> findTicketsByOrderId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_ALL_BY_ORDER_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(extractFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find tickets by session id", e);
            throw new DaoException();
        }
        return tickets;
    }

    @Override
    public Ticket findTicketById(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to fin a ticket by id ", e);
            throw new DaoException();
        }
        return null;
    }

    @Override
    public void createTicket(Ticket ticket) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_TICKET);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setInt(2, ticket.getOrder().getId());
            preparedStatement.setInt(3, ticket.getSession().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a ticket ", e);
            throw new DaoException();
        }
    }

    @Override
    public void deleteTicketById(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a ticket ", e);
            throw new DaoException();
        }
    }

    @Override
    public Ticket extractFromResultSet(ResultSet resultSet) throws DaoException {
        Ticket ticket = new Ticket();
        Order order = new Order();
        Session session = new Session();
        try {
            ticket.setId(resultSet.getInt(TICKET_ID));
            session.setId(resultSet.getInt(SESSION_ID));
            order.setId(resultSet.getInt(ORDER_ID));
            ticket.setOrder(order);
            ticket.setSession(session);
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract ticket from resul set", e);
            throw new DaoException();
        }
        return ticket;
    }
}