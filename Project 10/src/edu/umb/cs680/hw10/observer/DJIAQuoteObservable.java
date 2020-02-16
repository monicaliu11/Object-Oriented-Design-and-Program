package edu.umb.cs680.hw10.observer;

import edu.umb.cs680.hw10.DJIAEvent;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable {

    private float quote;

    public void changeQuote(float quote) {
        this.quote = quote;
        setChanged();
        notifyObservers(new DJIAEvent(quote));
    }
}
