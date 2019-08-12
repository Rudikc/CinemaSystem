package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Seance;

import java.sql.ResultSet;
import java.util.List;

public interface SeanceDao extends Dao<Seance> {
    List<Seance> findSeancesByDate(String date) throws DaoException;

    Seance extractFromResultSet(ResultSet resultSet) throws DaoException;
}
