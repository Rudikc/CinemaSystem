package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Seance;

import java.sql.ResultSet;
import java.util.List;

public interface SeanceDao extends Dao<Seance> {
    /**
     * Returns list of seances for given date
     * @param date
     * @return list of seances
     * @throws DaoException
     */
    List<Seance> findSeancesByDate(String date) throws DaoException;

    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    Seance extractFromResultSet(ResultSet resultSet) throws DaoException;
}
