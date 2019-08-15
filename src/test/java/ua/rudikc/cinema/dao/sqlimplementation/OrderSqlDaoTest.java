package ua.rudikc.cinema.dao.sqlimplementation;

import org.junit.Test;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.entity.Order;
import ua.rudikc.cinema.entity.User;

import java.sql.SQLException;
import java.util.Date;

public class OrderSqlDaoTest {

    @Test
    public void saveAndGetTheId() {
        OrderSqlDao orderSqlDao = new OrderSqlDao();
        Order order = new Order();
        order.setId(100);
        order.setOrderTime(new Date());
        order.setPrice(100);
        order.setUserId(1);
        try {
            System.out.println(orderSqlDao.transactionSave(order, ConnectionPool.getConnection()));
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}