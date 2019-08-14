package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.OrderSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.TicketSqlDao;
import ua.rudikc.cinema.dto.OrderDto;
import ua.rudikc.cinema.dto.TicketDto;
import ua.rudikc.cinema.entity.Order;
import ua.rudikc.cinema.entity.Ticket;
import ua.rudikc.cinema.entity.User;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    public OrderDto getOrderDtoById(int orderId) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        OrderDto orderDto = new OrderDto();

        try {
            Optional<Order> order = orderSqlDao.get(orderId);
            if (order.isPresent()) {
                orderDto.setId(orderId);
                orderDto.setOrderTime(order.get().getOrderTime());
                orderDto.setPrice(order.get().getPrice());
                orderDto.setUser(order.get().getUser());
                setTicketsToOrder(orderDto);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return orderDto;
    }

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

    public ArrayList<OrderDto> getUserOrders(User user) {
        OrderSqlDao orderSqlDao = (OrderSqlDao) DaoFactory.getDao(DaoFactory.ORDER_DAO);
        ArrayList<OrderDto> dtoOrders = new ArrayList<>();
        try {
            List<Order> orders = orderSqlDao.findUserOrders(user.getId());
            for (Order order :orders) {
                dtoOrders.add(getOrderDtoById(order.getId()));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return dtoOrders;
    }
}
