package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;

import java.sql.ResultSet;

public interface UserDao extends Dao<User> {
    void changeUserRole(User user, UserRole userRole) throws DaoException;

    boolean isRegistered(String email) throws DaoException;

    User findByEmailAndPassword(String email, String password) throws DaoException;

    User extractFromResultSet(ResultSet resultSet) throws DaoException;
}
