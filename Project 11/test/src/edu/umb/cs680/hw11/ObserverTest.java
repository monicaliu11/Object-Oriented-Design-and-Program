package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

public class ObserverTest {
    @Test
    public void test() {
        Observable<StockEvent> observable = new Observable<>();
        observable.addObserver(new StockEventObserver());
        observable.update(new StockEvent("ticket", 1.00f));
    }
}
