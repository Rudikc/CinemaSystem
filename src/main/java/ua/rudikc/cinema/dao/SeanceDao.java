package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Session;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public interface SessionDao {
    List<Session> findSeancesByDate(String date) throws DaoException;

    Session findSeanceById(int id) throws DaoException;

    void updateSeance(Session session) throws DaoException;

    void createSeance(Session session) throws DaoException;

    void deleteSeance(Session session) throws DaoException;

    Session extractFromResultSet(ResultSet resultSet) throws DaoException;

}
