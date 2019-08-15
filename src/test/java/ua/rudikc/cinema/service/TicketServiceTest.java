package ua.rudikc.cinema.service;

import org.junit.Test;
import ua.rudikc.cinema.dto.TicketDto;

public class TicketServiceTest {

    @Test
    public void getTicketDtoById() {
        TicketService ticketService = new TicketService();
        TicketDto ticketDto = ticketService.getTicketDtoById(1);
        System.out.println(ticketDto.getId());
        System.out.println(ticketDto.getSeance().getId());
        System.out.println(ticketDto.getSeance().getStart());
        System.out.println(ticketDto.getSeance().getEnd());
        System.out.println(ticketDto.getSeance().getFilm().getName());
        System.out.println(ticketDto.getSeance().getPrice());
        System.out.println(ticketDto.getSeat().getRow());
        System.out.println(ticketDto.getSeat().getPlace());
    }
}