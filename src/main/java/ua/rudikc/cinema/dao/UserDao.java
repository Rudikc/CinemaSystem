package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;

import java.sql.ResultSet;

/**
 * User dao
 */
public interface UserDao extends Dao<User> {
    /**
     * @param user
     * @param userRole
     * @throws DaoException
     */
    void changeUserRole(User user, UserRole userRole) throws DaoException;

    /**
     * Returns true if given email exist in database
     * @param email
     * @return
     * @throws DaoException
     */
    boolean isRegistered(String email) throws DaoException;

    /**
     * Finding user entity by email and password.
     * @param email
     * @param password
     * @return
     * @throws DaoException
     */
    User findByEmailAndPassword(String email, String password) throws DaoException;

    /**
     * Extracting entity from result set.
     * @param resultSet
     * @return entity
     */
    User extractFromResultSet(ResultSet resultSet) throws DaoException;
}
