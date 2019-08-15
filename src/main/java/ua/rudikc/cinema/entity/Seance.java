package ua.rudikc.cinema.entity;

import java.util.Date;

public class Seance {
    private int id;
    private Date start;
    private Date end;
    private int film;
    private double price;

    public Seance() {
    }

    public Seance(int id, Date start, Date end, int film, double price) {
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

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", film=" + film +
                ", price=" + price +
                '}';
    }
}
