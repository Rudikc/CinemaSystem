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

import static ua.rudikc.cinema.utils.Constants.*;

public class OrderSqlDao implements OrderDao {

    Logger logger = Logger.getLogger(OrderSqlDao.class);
    private static final String DELETE_BY_ID = "DELETE FROM cinema_db.orders WHERE order_id =?";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM cinema_db.orders WHERE order_id =?";
    private static final String SELECT_BY_USER_ID = "SELECT * FROM cinema_db.orders WHERE user_id =?";
    private static final String INSERT_ORDER = "INSERT INTO cinema_db.orders (user_id,price,order_time) VALUES (?,?,?)";
    private static final String UPDATE_ORDER = "UPDATE cinema_db.orders SET user_id = ?,price = ?, order_time = ?";

    @Override
    public void createOrder(Order order) throws DaoException {

        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(INSERT_ORDER);
            preparedStatement.setInt(1, order.getUser().getId());
            preparedStatement.setDouble(2, order.getPrice());
            preparedStatement.setDate(3, (Date) order.getOrderTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void deleteOrder(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateOrder(Order order) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(UPDATE_ORDER);
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
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(extractFromResulSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;

    }

    @Override
    public Order findOrderById(int id) throws DaoException {
        try {
            PreparedStatement preparedStatement = ConnectionPool.getConnection().prepareStatement(SELECT_ORDER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractFromResulSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order extractFromResulSet(ResultSet resultSet) throws DaoException {
        User user = new User();
        Order order = new Order();
        try {
            order.setId(resultSet.getInt(ORDER_ID));
            order.setPrice(resultSet.getDouble(ORDER_RRICE));
            user.setId(resultSet.getInt(ORDER_USER_ID));
            order.setUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
