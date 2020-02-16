package edu.umb.cs680.hw10;

public class StockEvent {

    private String ticket;
    private float quote;

    public StockEvent(String ticket, float quote) {
        this.ticket = ticket;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": [" + ticket + ", " + quote + "]";
    }
}
