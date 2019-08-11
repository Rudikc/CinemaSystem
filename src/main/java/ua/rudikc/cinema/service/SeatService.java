package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.SeatSqlDao;
import ua.rudikc.cinema.dao.sqlimplementation.TicketSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.Seat;
import ua.rudikc.cinema.model.Ticket;

import java.util.*;

public class SeatService {
    public ArrayList<ArrayList<Seat>> getListOfRowsOfSeats() {
        SeatSqlDao seatSqlDao = (SeatSqlDao) DaoFactory.getDao("seatDao");
        Map<Integer, ArrayList<Seat>> seatsMap = new TreeMap<>();
        try {
            List<Seat> allSeats = seatSqlDao.findAllSeats();
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
        TicketSqlDao ticketSqlDao = (TicketSqlDao) DaoFactory.getDao("ticketDao");
        ArrayList<Seat> busySeats = new ArrayList<>();
        try {
            List<Ticket> busyTickets = ticketSqlDao.findAllTicketsBySessionId(id);
            for (Ticket ticket : busyTickets) {
                busySeats.add(ticket.getSeat());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return busySeats;
    }
}
