package ua.rudikc.cinema.service;

import org.junit.Test;
import ua.rudikc.cinema.dto.OrderDto;
import ua.rudikc.cinema.dto.TicketDto;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void getOrderDtoById() {
        OrderService orderService = new OrderService();
        OrderDto orderDto = orderService.getOrderDtoById(1);
        for (TicketDto ticket: orderDto.getTickets()) {

            System.out.println(ticket.getSeat().getPlace());
            System.out.println(ticket.getSeat().getRow());
            System.out.println(ticket.getSeance().getFilm().getName());
            System.out.println(ticket.getSeance().getStart());

        }
    }
}