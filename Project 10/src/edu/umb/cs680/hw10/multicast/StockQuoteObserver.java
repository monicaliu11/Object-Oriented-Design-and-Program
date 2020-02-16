package edu.umb.cs680.hw10.multicast;

import edu.umb.cs680.hw10.StockEvent;

public interface StockQuoteObserver {
    void updateStock(StockEvent event);
}
