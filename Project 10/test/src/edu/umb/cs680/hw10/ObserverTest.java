package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.observer.*;
import org.junit.jupiter.api.Test;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ObserverTest {
    @Test
    public void test() {
        Observable[] observables = new Observable[]{new StockQuoteObservable(), new DJIAQuoteObservable()};
        Observer[] observers = new Observer[]{new PiechartObserver(), new TableObserver(), new ThreeDObserver()};
        for (Observable observable : observables) {
            for (Observer observer : observers) {
                observable.addObserver(observer);
            }
        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Observable observable = observables[random.nextInt(2)];
            if (observable instanceof StockQuoteObservable) {
                ((StockQuoteObservable)observable).changeQuote("ticket" + i, random.nextFloat());
            } else if (observable instanceof DJIAQuoteObservable) {
                ((DJIAQuoteObservable)observable).changeQuote(random.nextFloat());
            }
        }
    }
}
