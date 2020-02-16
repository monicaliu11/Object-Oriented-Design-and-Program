package edu.umb.cs680.hw10.multicast;

import edu.umb.cs680.hw10.DJIAEvent;
import edu.umb.cs680.hw10.StockEvent;

public class TableObserver implements StockQuoteObserver, DJIAQuoteObserver {
    @Override
    public void updateDJIA(DJIAEvent event) {
        System.out.println(String.format("Process table update for DJIA event: %s", event));
    }

    @Override
    public void updateStock(StockEvent event) {
        System.out.println(String.format("Process table update for Stock event: %s", event));
    }
}
