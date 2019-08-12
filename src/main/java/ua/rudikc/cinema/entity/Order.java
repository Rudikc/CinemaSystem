package ua.rudikc.cinema.entity;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int id;
    private User user;
    private double price;
    private Date orderTime;

    public Order() {
    }

    public Order(int id, User user, double price, Date orderTime) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.orderTime = orderTime;
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
}
