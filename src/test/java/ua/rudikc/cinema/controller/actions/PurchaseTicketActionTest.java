package ua.rudikc.cinema.controller.actions;

import org.junit.Test;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.dto.SeatDto;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.SeanceService;
import ua.rudikc.cinema.service.SeatService;

import static org.junit.Assert.*;

public class PurchaseTicketActionTest {

    @Test
    public void execute() {
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        SeatService seatService = (SeatService) ServiceFactory.getService("seatService");

        SeanceDto seanceDto = seanceService.getSeanceDtoById(1);
        SeatDto seatDto = seatService.getSeatDtoById(3);
        double ticketPrice = seanceDto.getPrice() * seatDto.getSeatType().getPriceMultiplier();

    }
}