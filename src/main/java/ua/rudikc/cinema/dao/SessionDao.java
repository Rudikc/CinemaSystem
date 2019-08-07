package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Session;

import java.sql.ResultSet;

public interface SessionDao {
    Session findSessionById(int id) throws DaoException;

    void updateSession(Session session) throws DaoException;

    void createSession(Session session) throws DaoException;

    void deleteSession(Session session) throws DaoException;

    Session extractFromResultSet(ResultSet resultSet) throws DaoException;

}
