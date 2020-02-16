package edu.umb.cs680.hw14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class YearComparatorTest {
    @Test
    public void testPriceComparator() {
    ArrayList<Car> usedCar = new ArrayList<>();

    Car car1 = new Car("A", "a", 20000, 2014, 5000);
    Car car2 = new Car("B", "b", 34829, 2018, 8000);
    Car car3 = new Car("C", "c", 27856, 2015, 7000);
    Car car4 = new Car("D", "d", 6700, 2016, 10000);
    Car car5 = new Car("E", "e", 17400, 2017, 9000);

        usedCar.add(car1);
        usedCar.add(car2);
        usedCar.add(car3);
        usedCar.add(car4);
        usedCar.add(car5);

    Car[] expecteds = {car2, car5, car4, car3,car1};
        Collections.sort(usedCar, (c1, c2) -> c2.getYear() - c1.getYear());
    Car[] actuals = usedCar.toArray(new Car[]{});
    assertArrayEquals(expecteds,actuals);
    }
}
