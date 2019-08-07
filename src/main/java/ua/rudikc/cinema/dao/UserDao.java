package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.User;
import ua.rudikc.cinema.model.UserRole;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    User getUserById(int id) throws DaoException;

    void createUser(User user) throws DaoException;

    void updateUser(User user) throws DaoException;

    void deleteUser(User user) throws DaoException;

    void changeUserRole(User user, UserRole userRole) throws DaoException;

    boolean isRegistered(String email) throws DaoException;

    User findByEmailAndPassword(String email, String password) throws DaoException;

    User extractFromResultSet(ResultSet resultSet) throws DaoException;
}
