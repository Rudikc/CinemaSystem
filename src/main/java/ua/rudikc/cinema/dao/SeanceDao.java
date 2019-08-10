package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Seance;

import java.sql.ResultSet;
import java.util.List;

public interface SeanceDao {
    List<Seance> findSeancesByDate(String date) throws DaoException;

    Seance findSeanceById(int id) throws DaoException;

    void updateSeance(Seance seance) throws DaoException;

    void createSeance(Seance seance) throws DaoException;

    void deleteSeance(Seance seance) throws DaoException;

    Seance extractFromResultSet(ResultSet resultSet) throws DaoException;

}
