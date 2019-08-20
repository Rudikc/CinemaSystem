package ua.rudikc.cinema.entity;

/**
 * Seat type entity
 */
public class SeatType {

    private int id;
    private String type;
    private double priceMultiplier;

    public SeatType() {
    }

    public SeatType(int id, String type, double priceMultiplier) {
        this.id = id;
        this.type = type;
        this.priceMultiplier = priceMultiplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public void setPriceMultiplier(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
}
