package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.model.Order;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> findUserOrders(int userId) throws DaoException;

    Order extractFromResultSet(ResultSet resultSet) throws DaoException;
}
