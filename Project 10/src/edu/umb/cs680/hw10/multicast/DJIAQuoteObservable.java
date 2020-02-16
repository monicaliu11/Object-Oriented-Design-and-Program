package edu.umb.cs680.hw10.multicast;

import edu.umb.cs680.hw10.DJIAEvent;

import java.util.ArrayList;
import java.util.List;

public class DJIAQuoteObservable implements DJIAQuoteObserver {

    private List<DJIAQuoteObserver> observers = new ArrayList<>();

    public DJIAQuoteObservable addObserver(DJIAQuoteObserver djiaQuoteObserver) {
        observers.add(djiaQuoteObserver);
        return this;
    }

    @Override
    public void updateDJIA(DJIAEvent event) {
        for (DJIAQuoteObserver observer : observers) {
            observer.updateDJIA(event);
        }
    }
}
