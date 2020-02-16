package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> extends java.util.Observable {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void update(T event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
