package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Order;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDao {
    void createOrder(Order order) throws DaoException;

    void deleteOrder(int id) throws DaoException;

    void updateOrder(Order order) throws DaoException;

    List<Order> findUserOrders(int userId) throws DaoException;

    Order findOrderById(int id) throws DaoException;

    Order extractFromResulSet(ResultSet resultSet) throws DaoException;
}
