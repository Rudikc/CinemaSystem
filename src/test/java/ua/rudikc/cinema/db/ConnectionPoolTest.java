package ua.rudikc.cinema.db;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectionPoolTest {

    @Test
    public void getConnection() {
        try {
            ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}