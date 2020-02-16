package edu.umb.cs680.hw11;

public class StockEventObserver implements Observer<StockEvent>{
    @Override
    public void update(StockEvent event) {
        System.out.println(getClass().getSimpleName() + " processes stock event: " + event);
    }
}
