package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.User;
import ua.rudikc.cinema.model.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.rudikc.cinema.utils.Constants.*;

public class UserSqlDao implements UserDao {

    private final static Logger logger = Logger.getLogger(UserSqlDao.class);

    private static final String SELECT_BY_ID = "SELECT * FROM cinema_db.users WHERE user_id = ?";
    private static final String SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM cinema_db WHERE email = ? AND password = ?";
    private static final String SELECT_BY_EMAIL = "SELECT * FROM cinema_db.users WHERE email = ?";
    private static final String UPDATE_ROLE = "UPDATE cinema_db.users SET user_role = ? WHERE user_id = ?";
    private final static String UPDATE_USER = "UPDATE cinema_db.users SET password=?, email=? ,first_name=?, last_name=?, user_role=?, phone=? WHERE user_id=?";
    private static final String INSERT_USER = "INSERT INTO cinema_db.users (password,email,first_name,last_name,user_role,phone) VALUES (?,?,?,?,?,?)";


    public UserSqlDao() {
    }

    @Override
    public User getUserById(int id) throws DaoException {
        User user = null;
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractFromResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find user by id ", e);
            throw new DaoException();
        }
        return user;
    }

    @Override
    public void createUser(User user) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, String.valueOf(user.getRole()));
            preparedStatement.setString(6, user.getPhone());

            if (0 < preparedStatement.executeUpdate()) {

            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to create a user ", e);
            throw new DaoException();
        }
    }

    @Override
    public void updateUser(User user) throws DaoException {
        try {
            PreparedStatement statement = ConnectionPool.getConnection().prepareStatement(UPDATE_USER);
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
    public void deleteUser(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserRole(User user, UserRole userRole) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_ROLE);
            preparedStatement.setString(1, String.valueOf(userRole));
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to change user role ", e);
            throw new DaoException();
        }
    }

    /**
     * mistake with return statement
     */
    @Override
    public boolean isRegistered(String email) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Something gone wrong while isRgistered method ", e);
            throw new DaoException();
        }
        return false;
    }


    @Override
    public User findByEmailAndPassword(String email, String password) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to find user by email and password ", e);
            throw new DaoException();
        }
        return null;
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
            user.setRole(UserRole.valueOf(resultSet.getString(USER_EMAIL)));
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Unable to extract a user from a result set ", e);
            throw new DaoException();
        }
        return user;
    }
}
