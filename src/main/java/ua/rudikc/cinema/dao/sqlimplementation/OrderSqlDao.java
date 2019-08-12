package ua.rudikc.cinema.dao.sqlimplementation;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.dao.OrderDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.model.Order;
import ua.rudikc.cinema.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.rudikc.cinema.dao.sqlimplementation.Queries.*;
import static ua.rudikc.cinema.utils.Constants.*;

public class OrderSqlDao implements OrderDao {

    private static final Logger logger = Logger.getLogger(OrderSqlDao.class);

    @Override
    public Optional<Order> get(int id) throws DaoException {
        Optional<Order> order = Optional.empty();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_ORDER.getQuery());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = Optional.of(extractFromResultSet(resultSet));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAll() throws DaoException {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_ALL_ORDERS.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(extractFromResultSet(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;

    }

    @Override
    public void save(Order order) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_ORDER.getQuery());
            preparedStatement.setInt(1, order.getUser().getId());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setDate(3, (Date) order.getOrderTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Order order) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_ORDER.getQuery());
            preparedStatement.setInt(1, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_ORDER.getQuery());
            preparedStatement.setInt(1, order.getUser().getId());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setDate(3, (Date) order.getOrderTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findUserOrders(int userId) throws DaoException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(GET_USERS_ORDERS.getQuery());
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(extractFromResultSet(resultSet));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order extractFromResultSet(ResultSet resultSet) throws DaoException {
        User user = new User();
        Order order = new Order();
        try {
            order.setId(resultSet.getInt(ORDER_ID));
            order.setPrice(resultSet.getDouble(ORDER_PRICE));
            user.setId(resultSet.getInt(ORDER_USER_ID));
            order.setUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
