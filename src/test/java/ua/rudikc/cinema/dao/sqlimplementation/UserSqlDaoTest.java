package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Level;
import org.junit.Test;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserSqlDaoTest {

    @Test
    public void isRegistered() throws SQLException, DaoException {
        UserSqlDao userSqlDao = new UserSqlDao();
        PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement("SELECT * FROM cinema_db.users WHERE email = 'mrudikc@gmail.com'");
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = userSqlDao.extractFromResultSet(resultSet);
        }
        assertEquals("mrudikc@gmail.com",user.getEmail());

    }
}