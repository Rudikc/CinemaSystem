package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.TicketDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;


public class TicketSqlDao implements TicketDao {

    private static final Logger logger = Logger.getLogger(TicketSqlDao.class);

    @Override
    public List<Ticket> findAllTicketsBySessionId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TICKETS_BY_SESSION_ID.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(extractFromResultSet(resultSet));
            }
            resultSet.close();


        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find tickets by session id", e);
            throw new DaoException();
        }
        return tickets;
    }

    @Override
    public List<Ticket> findTicketsByOrderId(int id) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TICKETS_BY_ORDER_ID.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(extractFromResultSet(resultSet));
            }
            resultSet.close();


        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find tickets by order id", e);
            throw new DaoException();
        }
        return tickets;
    }

    @Override
    public Optional<Ticket> get(int id) throws DaoException {
        Optional<Ticket> ticket = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TICKET.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ticket = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to fin a ticket by id ", e);
            throw new DaoException();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getAll() throws DaoException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TICKETS.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tickets.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public void save(Ticket ticket) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET.getQuery());
            preparedStatement.setInt(1, ticket.getSeatId());
            preparedStatement.setInt(2, ticket.getOrder());
            preparedStatement.setInt(3, ticket.getSeance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a ticket ", e);
            throw new DaoException();
        }
    }

    @Override
    public void update(Ticket ticket) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET.getQuery());
            preparedStatement.setInt(1, ticket.getSeatId());
            preparedStatement.setInt(2, ticket.getOrder());
            preparedStatement.setInt(3, ticket.getSeance());
            preparedStatement.setInt(4, ticket.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET.getQuery());
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a ticket ", e);
            throw new DaoException();
        }
    }

    @Override
    public Ticket extractFromResultSet(ResultSet resultSet) throws DaoException {
        Ticket ticket = new Ticket();
        try {
            ticket.setId(resultSet.getInt(TICKET_ID));
            ticket.setOrder(resultSet.getInt(TICKET_ORDER_ID));
            ticket.setSeance(resultSet.getInt(TICKET_SEANCE_ID));
            ticket.setSeatId(resultSet.getInt(TICKET_SEAT_ID));
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract ticket from result set", e);
            throw new DaoException();
        }
        return ticket;
    }
}
