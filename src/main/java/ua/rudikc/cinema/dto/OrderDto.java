package ua.rudikc.cinema.dto;

import ua.rudikc.cinema.entity.Order;
import ua.rudikc.cinema.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {

    private int id;
    private User user;
    private double price;
    private Date orderTime;
    private List<TicketDto> tickets;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        this.user = order.getUser();
        this.price = order.getPrice();
        this.orderTime = order.getOrderTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }

}
