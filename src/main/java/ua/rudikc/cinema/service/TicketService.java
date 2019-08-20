package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.SeatSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.TicketSqlDao;
import ua.rudikc.cinema.dto.SeanceDto;
import ua.rudikc.cinema.dto.TicketDto;
import ua.rudikc.cinema.entity.Seat;
import ua.rudikc.cinema.entity.Ticket;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.factory.ServiceFactory;

import java.util.Optional;

/**
 * Service for work with tickets
 */
public class TicketService {

    /**
     * Returns ticket dto by ticket entity id
     * @param ticketId
     * @return
     */
    public TicketDto getTicketDtoById(int ticketId) {
        SeatSqlDao seatSqlDao = (SeatSqlDao) DaoFactory.getDao(DaoFactory.SEAT_DAO);
        SeanceService seanceService = (SeanceService) ServiceFactory.getService("seanceService");
        TicketSqlDao ticketSqlDao = (TicketSqlDao) DaoFactory.getDao(DaoFactory.TICKET_DAO);
        Optional<Ticket> ticket;
        SeanceDto seance;
        Optional<Seat> seat;
        TicketDto ticketDto = new TicketDto();

        try {
            ticket = ticketSqlDao.get(ticketId);
            if (ticket.isPresent()) {
                seance = seanceService.getSeanceDtoById(ticket.get().getSeance());
                seat = seatSqlDao.get(ticket.get().getSeatId());
                ticketDto.setSeance(seance);
                seat.ifPresent(ticketDto::setSeat);
                ticketDto.setId(ticket.get().getId());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return ticketDto;
    }

}
