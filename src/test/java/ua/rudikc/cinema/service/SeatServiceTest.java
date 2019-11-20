package ua.rudikc.cinema.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.rudikc.cinema.entity.Seat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SeatServiceTest {

    private static SeatService seatService;

    @BeforeClass
    private static void init() {
        seatService = new SeatService();
    }

    @Before
    private static void setUp(){
        List<Seat> seats = new ArrayList<>();
    }

    @Test
    public void getListOfRowsOfSeats() {
        int numberOfRows = 6;
        int actualNumberOfRows = seatService.getListOfRowsOfSeats().size();
        assertEquals(numberOfRows,actualNumberOfRows);
    }
}