package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.OrderSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.TicketSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.UserSqlDao;
import ua.rudikc.cinema.db.ConnectionPool;
import ua.rudikc.cinema.dto.OrderDto;
import ua.rudikc.cinema.dto.TicketDto;
import ua.rudikc.cinema.entity.Order;
import ua.rudikc.cinema.entity.Ticket;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.factory.ServiceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderService {

    /**
     * Saves the order to database
     * @param order
     * @param seanceId
     * @param seatId
     */
    public void saveOrder(Order order, int seanceId, int seatId) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        TicketSqlDao ticketSqlDao = (TicketSqlDao) DaoFactory.getDao(DaoFactory.TICKET_DAO);
        Connection connection = null;

        try {
            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);
            Integer orderId = orderSqlDao.transactionSave(order, connection);
            Ticket ticket = Ticket.newBuilder()
                    .setOrderId(orderId)
                    .setSeanceId(seanceId)
                    .setSeatId(seatId)
                    .build();
            connection.commit();
            ticketSqlDao.save(ticket);
            connection.commit();
        } catch (SQLException | DaoException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * Removes order from database
     * @param user
     * @param orderId
     */
    public void removeOrder(User user, int orderId) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        try {
            Optional<Order> orderByIdFromDb = orderSqlDao.get(orderId);
            if (orderByIdFromDb.isPresent() && orderByIdFromDb.get().getUserId() == user.getId()) {
                orderSqlDao.delete(orderByIdFromDb.get());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns order dto by the order id
     * @param orderId
     * @return order dto
     */
    public OrderDto getOrderDtoById(int orderId) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        UserSqlDao userSqlDao = (UserSqlDao) DaoFactory.getDao(DaoFactory.USER_DAO);
        OrderDto orderDto = new OrderDto();

        try {
            Optional<Order> order = orderSqlDao.get(orderId);
            if (order.isPresent()) {
                Optional<User> user = userSqlDao.get(order.get().getUserId());
                orderDto.setId(orderId);
                orderDto.setOrderTime(order.get().getOrderTime());
                orderDto.setPrice(order.get().getPrice());
                user.ifPresent(orderDto::setUser);
                setTicketsToOrder(orderDto);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return orderDto;
    }

    /**
     * Setting tickets to order dto
     * @param orderDto
     * @return order dto with sated tickets
     */
    private OrderDto setTicketsToOrder(OrderDto orderDto) {
        TicketSqlDao ticketSqlDao = (TicketSqlDao) DaoFactory.getDao(DaoFactory.TICKET_DAO);
        TicketService ticketService = (TicketService) ServiceFactory.getService("ticketService");
        try {
            List<Ticket> tickets = ticketSqlDao.findTicketsByOrderId(orderDto.getId());
            List<TicketDto> dtoTickets = new ArrayList<>();
            for (Ticket ticket : tickets) {
                dtoTickets.add(ticketService.getTicketDtoById(ticket.getId()));
            }
            orderDto.setTickets(dtoTickets);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return orderDto;
    }

    /**
     * Returns a list of user orders
     * @param user
     * @return
     */
    public ArrayList<OrderDto> getUserOrders(User user) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        ArrayList<OrderDto> dtoOrders = new ArrayList<>();
        try {
            List<Order> orders = orderSqlDao.findUserOrders(user.getId());
            for (Order order : orders) {
                dtoOrders.add(getOrderDtoById(order.getId()));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Collections.reverse(dtoOrders);
        return dtoOrders;
    }
}
