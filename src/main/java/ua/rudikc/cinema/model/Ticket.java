package ua.rudikc.cinema.model;

public class Ticket {
    private int id;
    private Seat seat;
    private Order order;
    private Seance seance;

    public Ticket() {
    }

    public Ticket(int id, Seat seat, Order order, Seance seance) {
        this.id = id;
        this.seat = seat;
        this.order = order;
        this.seance = seance;
    }

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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

}
