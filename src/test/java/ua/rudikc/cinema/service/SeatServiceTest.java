package ua.rudikc.cinema.service;

import org.junit.Test;

public class SeatServiceTest {

    @Test
    public void getFreeSeatsBySessionId() {
        SeatService seatService = new SeatService();
        System.out.println(seatService.getListOfRowsOfSeats().size());
    }

    @Test
    public void getFreeSeatsById() {
        SeatService seatService = new SeatService();
        System.out.println(seatService.getBusySeatsById(1));
    }
}