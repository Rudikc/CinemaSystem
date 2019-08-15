package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> findUserOrders(int userId) throws DaoException;

    Integer transactionSave(Order order, Connection connection) throws DaoException;

    Order extractFromResultSet(ResultSet resultSet) throws DaoException;
}
