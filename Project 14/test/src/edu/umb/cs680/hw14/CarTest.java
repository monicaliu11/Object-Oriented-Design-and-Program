package edu.umb.cs680.hw14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private String[] carToStringArrary(Car c) {
        String[] carInfo = {
                c.getMake(),
                c.getModel(),
                Integer.toString(c.getYear())
        };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Toyota", "Highlander", "2019"};
        Car actual = new Car("Toyota", "Highlander", 1000, 2019, 30000);
        assertArrayEquals(expected, carToStringArrary(actual));
    }

    @Test
    public void testGetFunction() {
        Car car = new Car("Honda", "Civic", 500,2019, 21000);
        String expectMake = "Honda";
        String expectModel = "Civic";
        int expectMileage = 500;
        int expectYear = 2019;
        float expectPrice = 21000;
        assertEquals(expectMake, car.getMake());
        assertEquals(expectModel, car.getModel());
        assertEquals(expectMileage, car.getMileage());
        assertEquals(expectYear, car.getYear());
        assertEquals(expectPrice, car.getPrice());
    }

}
