package ua.rudikc.cinema.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void newBuilder() {
        Order order =Order.newBuilder().setOrderTime().setPrice(100).setUser(1).build();
        System.out.println(order);
    }
}