package ua.rudikc.cinema.dto;

import ua.rudikc.cinema.entity.Seat;

public class TicketDto {
    private int id;
    private Seat seat;
    private SeanceDto seance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeanceDto getSeance() {
        return seance;
    }

    public void setSeance(SeanceDto seance) {
        this.seance = seance;
    }
}
