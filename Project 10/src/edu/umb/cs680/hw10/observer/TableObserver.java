package edu.umb.cs680.hw10.observer;

import edu.umb.cs680.hw10.DJIAEvent;
import edu.umb.cs680.hw10.StockEvent;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof StockEvent) {
            System.out.println(String.format("Process table update for Stock event %s", arg));
        } else if (arg instanceof DJIAEvent){
            System.out.println(String.format("Process table update for DJIA event %s", arg));
        }
    }
}
