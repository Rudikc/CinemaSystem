package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SessionDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Film;
import ua.rudikc.cinema.model.Session;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.rudikc.cinema.utils.Constants.*;

public class SessionSqlDao implements SessionDao {

    Logger logger = Logger.getLogger(SessionSqlDao.class);

    private static final String FIND_BY_ID = "SELECT * FROM cinema_db.sessions WHERE session_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.sessions WHERE session_id = ?";
    private final static String UPDATE_SESSION = "UPDATE cinema_db.sessions SET session_start=?,session_end=?,film_id=?,ticket_price=? WHERE session_id=?";
    private static final String INSERT_SESSION = "INSERT INTO cinema_db.sessions (session_start,session_end,film_id,ticket_price) VALUES (?,?,?,?)";

    @Override
    public Session findSessionById(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find a session by id ", e);
            throw new DaoException();
        }
        return null;
    }

    @Override
    public void updateSession(Session session) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_SESSION);
            preparedStatement.setDate(1, (Date) session.getStart());
            preparedStatement.setDate(2, (Date) session.getEnd());
            preparedStatement.setInt(3, session.getFilm().getId());
            preparedStatement.setDouble(4, session.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to update a session ", e);
            throw new DaoException();
        }
    }

    @Override
    public void createSession(Session session) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_SESSION);
            preparedStatement.setDate(1, (Date) session.getStart());
            preparedStatement.setDate(2, (Date) session.getEnd());
            preparedStatement.setInt(3, session.getFilm().getId());
            preparedStatement.setDouble(4, session.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a session ", e);
            throw new DaoException();
        }

    }

    @Override
    public void deleteSession(Session session) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, session.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a session ", e);
            throw new DaoException("Session cant be deleted");
        }
    }

    @Override
    public Session extractFromResultSet(ResultSet resultSet) throws DaoException {
        Session session = new Session();
        Film film = new Film();
        try {
            session.setId(resultSet.getInt(SESSION_ID));
            session.setStart(resultSet.getDate(SESSION_START));
            session.setEnd(resultSet.getDate(SESSION_END));
            film.setId(resultSet.getInt(SESSION_FILM_ID));
            session.setFilm(film);
            session.setPrice(resultSet.getDouble(SESSION_TICKET_PRICE));

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a session from result set ", e);
            throw new DaoException();
        }
        return session;
    }
}
