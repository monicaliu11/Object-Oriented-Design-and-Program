package edu.umb.cs680.hw09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        int dominantCount = 0;
        if (car1.getPrice() < car2.getPrice()) {
            dominantCount--;
        } else if (car1.getPrice() > car2.getPrice()){
            dominantCount++;
        }

        if (car1.getMileage() < car2.getMileage()) {
            dominantCount--;
        } else if (car1.getMileage() > car2.getMileage()) {
            dominantCount++;
        }

        if (car1.getYear() > car2.getYear()) {
            dominantCount--;
        } else if (car1.getYear() < car2.getMileage()) {
            dominantCount++;
        }
        return dominantCount;
    }

}
