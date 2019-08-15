package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.SeatSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.SeatTypeSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.TicketSqlDao;
import ua.rudikc.cinema.dto.SeatDto;
import ua.rudikc.cinema.entity.SeatType;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.entity.Seat;
import ua.rudikc.cinema.entity.Ticket;
import ua.rudikc.cinema.factory.ServiceFactory;

import java.util.*;

public class SeatService {

    public SeatDto getSeatDtoById(int seatId){
        SeatSqlDao seatSqlDao = (SeatSqlDao) DaoFactory.getDao(DaoFactory.SEAT_DAO);
        SeatTypeSqlDao seatTypeSqlDao = (SeatTypeSqlDao) DaoFactory.getDao(DaoFactory.SEAT_TYPE_DAO);
        SeatDto seatDto = new SeatDto();

        try {
            Optional<Seat> seat = seatSqlDao.get(seatId);
            if (seat.isPresent()) {
                Optional<SeatType> seatType = seatTypeSqlDao.get(seat.get().getSeatTypeId());
                seatDto = new SeatDto(seat.get());
                seatType.ifPresent(seatDto::setSeatType);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return seatDto;
    }
    public ArrayList<ArrayList<Seat>> getListOfRowsOfSeats() {
        SeatSqlDao seatSqlDao = (SeatSqlDao) DaoFactory.getDao("seatDao");
        Map<Integer, ArrayList<Seat>> seatsMap = new TreeMap<>();
        try {
            List<Seat> allSeats = seatSqlDao.getAll();
            for (Seat seat : allSeats) {
                if (seatsMap.get(seat.getRow()) != null) {
                    seatsMap.get(seat.getRow()).add(seat);
                } else {
                    ArrayList<Seat> row = new ArrayList<>();
                    row.add(seat);
                    seatsMap.put(seat.getRow(), row);
                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(seatsMap.values());
    }

    public ArrayList<Seat> getBusySeatsById(int id) {
        SeatService seatService = (SeatService) ServiceFactory.getService("seatService");
        SeatSqlDao seatSqlDao = (SeatSqlDao) DaoFactory.getDao(DaoFactory.SEAT_DAO);
        TicketSqlDao ticketSqlDao = (TicketSqlDao) DaoFactory.getDao("ticketDao");
        ArrayList<Seat> busySeats = new ArrayList<>();
        try {
            List<Ticket> busyTickets = ticketSqlDao.findAllTicketsBySessionId(id);
            for (Ticket ticket : busyTickets) {
                seatSqlDao.get(ticket.getSeatId()).ifPresent(busySeats::add);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return busySeats;
    }
}
