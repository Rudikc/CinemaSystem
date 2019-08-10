package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SessionDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Film;
import ua.rudikc.cinema.model.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class SessionSqlDao implements SessionDao {

    private Logger logger = Logger.getLogger(SessionSqlDao.class);


    private static final String FIND_SESSIONS_BY_DATE = "SELECT * FROM cinema_db.sessions WHERE DATE(session_start) = ?";
    private static final String FIND_BY_ID = "SELECT * FROM cinema_db.sessions WHERE session_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.sessions WHERE session_id = ?";
    private final static String UPDATE_SESSION = "UPDATE cinema_db.sessions SET session_start=?,session_end=?,film_id=?,ticket_price=? WHERE session_id=?";
    private static final String INSERT_SESSION = "INSERT INTO cinema_db.sessions (session_start,session_end,film_id,ticket_price) VALUES (?,?,?,?)";


    @Override
    public List<Session> findSeancesByDate(String date) throws DaoException {
        ArrayList<Session> sessions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_SESSIONS_BY_DATE);
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sessions.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }

    @Override
    public Session findSeanceById(int id) throws DaoException {
        Session session = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find a session by id ", e);
            throw new DaoException();
        }
        return null;
    }

    @Override
    public void updateSeance(Session session) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_SESSION);
            preparedStatement.setTimestamp(1, (Timestamp) session.getStart());
            preparedStatement.setTimestamp(2, (Timestamp) session.getEnd());
            preparedStatement.setInt(3, session.getFilm().getId());
            preparedStatement.setDouble(4, session.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to update a session ", e);
            throw new DaoException();
        }
    }

    @Override
    public void createSeance(Session session) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_SESSION);
            preparedStatement.setTimestamp(1, (Timestamp) session.getStart());
            preparedStatement.setTimestamp(2, (Timestamp) session.getEnd());
            preparedStatement.setInt(3, session.getFilm().getId());
            preparedStatement.setDouble(4, session.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a session ", e);
            throw new DaoException();
        }

    }

    @Override
    public void deleteSeance(Session session) throws DaoException {
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
            session.setStart(resultSet.getTimestamp(SESSION_START));
            session.setEnd(resultSet.getTimestamp(SESSION_END));
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
