package edu.umb.cs680.hw14;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return (int) (car1.getPrice() - car2.getPrice());
    }
}
