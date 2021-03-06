package ua.rudikc.cinema.entity;

import java.util.Objects;

/**
 * Seat entity
 */
public class Seat {

    private int id;
    private int row;
    private int place;
    private int seatTypeId;

    public Seat() {
    }

    public Seat(int id, int row, int place, int seatType) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.seatTypeId = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatType) {
        this.seatTypeId = seatType;
    }
}
