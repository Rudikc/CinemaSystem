package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.SeanceDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Film;
import ua.rudikc.cinema.model.Seance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.rudikc.cinema.utils.Constants.*;

public class SeanceSqlDao implements SeanceDao {

    private Logger logger = Logger.getLogger(SeanceSqlDao.class);


    private static final String FIND_SEANCES_BY_DATE = "SELECT * FROM cinema_db.seances WHERE DATE(seance_start) = ?";
    private static final String FIND_BY_ID = "SELECT * FROM cinema_db.seances WHERE seance_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.seances WHERE seance_id = ?";
    private final static String UPDATE_SEANCE = "UPDATE cinema_db.seances SET seance_start=?,seance_end=?,film_id=?,ticket_price=? WHERE seance_id=?";
    private static final String INSERT_SEANCE = "INSERT INTO cinema_db.seances (seance_start,seance_end,film_id,ticket_price) VALUES (?,?,?,?)";


    @Override
    public List<Seance> findSeancesByDate(String date) throws DaoException {
        ArrayList<Seance> seances = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_SEANCES_BY_DATE);
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                seances.add(extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seances;
    }

    @Override
    public Seance findSeanceById(int id) throws DaoException {
        Seance seance = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find a seance by id ", e);
            throw new DaoException();
        }
        return null;
    }

    @Override
    public void updateSeance(Seance seance) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_SEANCE);
            preparedStatement.setTimestamp(1, (Timestamp) seance.getStart());
            preparedStatement.setTimestamp(2, (Timestamp) seance.getEnd());
            preparedStatement.setInt(3, seance.getFilm().getId());
            preparedStatement.setDouble(4, seance.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to update a seance ", e);
            throw new DaoException();
        }
    }

    @Override
    public void createSeance(Seance seance) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_SEANCE);
            preparedStatement.setTimestamp(1, (Timestamp) seance.getStart());
            preparedStatement.setTimestamp(2, (Timestamp) seance.getEnd());
            preparedStatement.setInt(3, seance.getFilm().getId());
            preparedStatement.setDouble(4, seance.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a seance ", e);
            throw new DaoException();
        }

    }

    @Override
    public void deleteSeance(Seance seance) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, seance.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to delete a seance ", e);
            throw new DaoException("Seance cant be deleted");
        }
    }

    @Override
    public Seance extractFromResultSet(ResultSet resultSet) throws DaoException {
        Seance seance = new Seance();
        Film film = new Film();
        try {
            seance.setId(resultSet.getInt(SEANCE_ID));
            seance.setStart(resultSet.getTimestamp(SEANCE_START));
            seance.setEnd(resultSet.getTimestamp(SEANCE_END));
            film.setId(resultSet.getInt(SEANCE_FILM_ID));
            seance.setFilm(film);
            seance.setPrice(resultSet.getDouble(SEANCE_TICKET_PRICE));

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a seance from result set ", e);
            throw new DaoException();
        }
        return seance;
    }
}
