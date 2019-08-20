package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.entity.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    /**
     * Finds all users orders.
     * @param userId user
     * @return list of orders
     * @throws DaoException
     */
    List<Order> findUserOrders(int userId) throws DaoException;

    /**
     * @param order
     * @param connection
     * @return
     * @throws DaoException
     */
    Integer transactionSave(Order order, Connection connection) throws DaoException;

    /**
     * Extracting entity from result set
     * @param resultSet
     * @return entity
     */
    Order extractFromResultSet(ResultSet resultSet) throws DaoException;
}
