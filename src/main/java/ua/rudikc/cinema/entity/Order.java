package ua.rudikc.cinema.entity;

import java.util.Date;

public class Order {

    private int id;
    private int userId;
    private double price;
    private Date orderTime;

    public Order() {
    }

    public Order(int id, int userId, double price, Date orderTime) {
        this.id = id;
        this.userId = userId;
        this.price = price;
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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


    public static Builder newBuilder() {
        return new Order().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder setOrderTime() {
            Order.this.orderTime = new Date();
            return this;
        }

        public Builder setUser(int user) {
            Order.this.userId = user;
            return this;
        }

        public Builder setPrice(double price) {
            Order.this.price = price;
            return this;
        }

        public Order build() {
            return Order.this;
        }
    }


}
