package ua.rudikc.cinema.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Apache commons DBCP
 */
public class ConnectionPool {

    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        ResourceBundle dbSettings = ResourceBundle.getBundle("databaseConfiguration/dbSettings");
        basicDataSource.setUrl(dbSettings.getString("url"));
        basicDataSource.setUsername(dbSettings.getString("username"));
        basicDataSource.setPassword(dbSettings.getString("password"));
        basicDataSource.setMaxOpenPreparedStatements(100);
        basicDataSource.setMaxTotal(Integer.parseInt(dbSettings.getString("poolsize"))*4);
        basicDataSource.setInitialSize(Integer.parseInt(dbSettings.getString("poolsize")));
        basicDataSource.setMinIdle(Integer.parseInt(dbSettings.getString("poolsize")));
        basicDataSource.setMaxIdle(Integer.parseInt(dbSettings.getString("poolsize")) * 2);
    }

    /**
     * Giving the connection
     * @return connection with database
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return basicDataSource.getConnection();
    }

    private ConnectionPool() {
    }
}
