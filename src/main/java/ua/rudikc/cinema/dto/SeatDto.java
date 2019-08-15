package ua.rudikc.cinema.dto;

import ua.rudikc.cinema.entity.Seat;
import ua.rudikc.cinema.entity.SeatType;

import java.util.Objects;

public class SeatDto {
    private int id;
    private int row;
    private int place;
    private SeatType seatType;

    public SeatDto() {
    }

    public SeatDto (Seat seat){
        this.id = seat.getId();
        this.row = seat.getRow();
        this.place = seat.getPlace();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDto seatDto = (SeatDto) o;
        return id == seatDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
