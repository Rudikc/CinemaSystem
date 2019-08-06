package ua.rudikc.cinema.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static final BasicDataSource basicDataSource = new BasicDataSource();

    static {
        ResourceBundle dbSettings = ResourceBundle.getBundle("dbSettings");
        basicDataSource.setUrl(dbSettings.getString("url"));
        basicDataSource.setUsername(dbSettings.getString("username"));
        basicDataSource.setPassword(dbSettings.getString("password"));
        basicDataSource.setInitialSize(Integer.parseInt(dbSettings.getString("poolsize")));
        basicDataSource.setMaxTotal(Integer.parseInt(dbSettings.getString("poolsize")) * 4);
        basicDataSource.setMinIdle(Integer.parseInt(dbSettings.getString("poolsize")));
        basicDataSource.setMaxIdle(Integer.parseInt(dbSettings.getString("poolsize")) * 2);
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private ConnectionPool() {
    }
}
