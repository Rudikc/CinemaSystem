package ua.rudikc.cinema.model;

public class Ticket {
    private int id;
    private Seat seat;
    private Order order;
    private Session session;

    public Ticket() {
    }

    public Ticket(int id, Seat seat, Order order, Session session) {
        this.id = id;
        this.seat = seat;
        this.order = order;
        this.session = session;
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
