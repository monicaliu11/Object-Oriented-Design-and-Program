package edu.umb.cs680.hw10.multicast;

import edu.umb.cs680.hw10.StockEvent;

import java.util.ArrayList;
import java.util.List;

public class StockQuoteObservable implements StockQuoteObserver {

    private List<StockQuoteObserver> observers = new ArrayList<>();

    public StockQuoteObservable addObserver(StockQuoteObserver observer) {
        observers.add(observer);
        return this;
    }

    @Override
    public void updateStock(StockEvent event) {
        for (StockQuoteObserver observer : observers) {
            observer.updateStock(event);
        }
    }
}
