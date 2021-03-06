package ua.rudikc.cinema.controller.actions.ticket;

import ua.rudikc.cinema.controller.actions.Action;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.dto.SeatDto;
import ua.rudikc.cinema.factory.ServiceFactory;
import ua.rudikc.cinema.service.SeanceService;
import ua.rudikc.cinema.service.SeatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PurchaseTicketAction implements Action {
    /**
     * Action that redirect user to purchase confirmation of the ticket.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        SeatService seatService = (SeatService) ServiceFactory.getService("seatService");

        SeanceDto seanceDto = seanceService.getSeanceDtoById(Integer.parseInt(request.getParameter("seance-id")));
        SeatDto seatDto = seatService.getSeatDtoById(Integer.parseInt(request.getParameter("seat-id")));
        double ticketPrice = seanceDto.getPrice() * seatDto.getSeatType().getPriceMultiplier();

        request.setAttribute("seance",seanceDto);
        request.setAttribute("ticket_price",ticketPrice);
        request.setAttribute("seat",seatDto);


        return "purchase-ticket";
    }
}
