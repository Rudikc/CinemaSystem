package ua.rudikc.cinema.model;

import java.util.Date;

public class Session {
    private int id;
    private Date start;
    private Date end;
    private Film film;
    private double price;

    public Session() {
    }

    public Session(int id, Date start, Date end, Film film, double price) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.film = film;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
