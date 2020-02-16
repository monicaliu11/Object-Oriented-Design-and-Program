package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.multicast.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MulticastTest {

    @Test
    public void test() {
        PiechartObserver piechartObserver = new PiechartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();

        StockQuoteObservable stockQuoteObservable = new StockQuoteObservable()
                .addObserver(piechartObserver)
                .addObserver(tableObserver)
                .addObserver(threeDObserver);

        DJIAQuoteObservable djiaQuoteObserver = new DJIAQuoteObservable()
                .addObserver(piechartObserver)
                .addObserver(tableObserver)
                .addObserver(threeDObserver);


        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean stock = random.nextBoolean();
            if (stock) {
                stockQuoteObservable.updateStock(new StockEvent("ticket" + i, random.nextFloat()));
            } else {
                djiaQuoteObserver.updateDJIA(new DJIAEvent(random.nextFloat()));
            }
        }
    }
}
