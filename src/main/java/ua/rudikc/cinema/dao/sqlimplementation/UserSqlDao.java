package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.entity.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;


public class UserSqlDao implements UserDao {

    private final static Logger logger = Logger.getLogger(UserSqlDao.class);

    @Override
    public Optional<User> get(int id) throws DaoException {
        Optional<User> user = Optional.empty();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_USER.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(extractFromResultSet(resultSet));
            }

            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find user by id ", e);
            throw new DaoException();
        }
        return user;
    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_ALL_USERS.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public void save(User user) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_USER.getQuery());
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, String.valueOf(user.getRole()));
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a user ", e);
            throw new DaoException();
        }
    }

    @Override
    public void update(User user) throws DaoException {
        try {
            PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(UPDATE_USER.getQuery());
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, String.valueOf(user.getRole()));
            statement.setString(6, user.getPhone());
            statement.setInt(7, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to update a user ", e);
            throw new DaoException();
        }
    }

    @Override
    public void delete(User user) {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_USER.getQuery());
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeUserRole(User user, UserRole userRole) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_USERS_ROLE.getQuery());
            preparedStatement.setString(1, String.valueOf(userRole));
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to change user role ", e);
            throw new DaoException();
        }
    }

    @Override
    public boolean isRegistered(String email) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_USER_BY_EMAIL.getQuery());
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Something gone wrong while isRegistered method ", e);
            throw new DaoException();
        }
    }


    @Override
    public User findByEmailAndPassword(String email, String password) throws DaoException {
        User user = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_USER_BY_EMAIL_AND_PASSWORD.getQuery());
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find user by email and password ", e);
            throw new DaoException();
        }
        return user;
    }

    @Override
    public User extractFromResultSet(ResultSet resultSet) throws DaoException {
        User user = new User();
        try {
            user.setId(resultSet.getInt(USER_ID));
            user.setEmail(resultSet.getString(USER_EMAIL));
            user.setPassword(resultSet.getString(USER_PASSWORD));
            user.setFirstName(resultSet.getString(USER_FIRST_NAME));
            user.setLastName(resultSet.getString(USER_LAST_NAME));
            user.setPhone(resultSet.getString(USER_PHONE));
            user.setRole(UserRole.valueOf(resultSet.getString(USER_ROLE)));
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a user from a result set ", e);
            throw new DaoException();
        }
        return user;
    }
}
