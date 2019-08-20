package ua.rudikc.cinema.entity;

/**
 * Ticket entity
 */
public class Ticket {
    private int id;
    private int seatId;
    private int orderId;
    private int seanceId;

    public Ticket() {
    }

    public Ticket(int id, int seat, int order, int seance) {
        this.id = id;
        this.seanceId = seat;
        this.orderId = order;
        this.seanceId = seance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seat) {
        this.seatId = seat;
    }

    public int getOrder() {
        return orderId;
    }

    public void setOrder(int order) {
        this.orderId = order;
    }

    public int getSeance() {
        return seanceId;
    }

    public void setSeance(int seance) {
        this.seanceId = seance;
    }

    public static Builder newBuilder() {
        return new Ticket().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setSeatId(int seatId) {
            Ticket.this.seatId = seatId;
            return this;
        }

        public Builder setSeanceId(int seanceId){
            Ticket.this.seanceId = seanceId;
            return this;
        }
        public Builder setOrderId(int orderId){
            Ticket.this.orderId = orderId;
            return this;
        }

        public Ticket build(){
            return Ticket.this;
        }
    }
}
