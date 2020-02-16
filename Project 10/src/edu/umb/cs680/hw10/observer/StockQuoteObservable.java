package edu.umb.cs680.hw10.observer;

import edu.umb.cs680.hw10.StockEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable {
    private Map<String, Float> quoteMap = new HashMap<>();

    public void changeQuote(String ticket, float quote) {
        quoteMap.put(ticket, quote);
        setChanged();
        notifyObservers(new StockEvent(ticket, quote));
    }
}
