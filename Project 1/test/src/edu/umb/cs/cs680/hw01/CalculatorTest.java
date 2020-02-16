package edu.umb.cs.cs680.hw01;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.CallableStatement;

public class CalculatorTest {

    @Test
    public void multiply3By4() {
        Calculator cut = new Calculator();
        float expected = 12;
        float actual = cut.multiply(3,4);
        assertEquals(actual, expected);
    }

    @Test
    public void multiple2_5By5_5() {
        Calculator cut = new Calculator();
        float expected = 13.75f;
        float actual = cut.multiply(2.5f, 5.5f);
        assertEquals(actual, expected);
    }

    @Test
    public void multiple7_3By0() {
        Calculator cut = new Calculator();
        float expected = 0;
        float actual = cut.multiply(7.3f, 0);
        assertEquals(actual,expected);
    }

    @Test
    public void divide3By2() {
        Calculator cut = new Calculator();
        float actual = cut.divide(3,2);
        float expected = 1.5f;
        assertEquals(expected, actual);
    }

    @Test
    public void divide1_5by0_5() {
        Calculator cut = new Calculator();
        float actual = cut.divide(1.5f, 0.5f);
        float expected = 3;
        assertEquals(expected, actual);
    }


    @Test
    public void divide5By0() {
        Calculator cut = new Calculator();
        try{
            cut.divide(5, 0);
            fail("Division by zero");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("division by zero", ex.getMessage());
        }
    }



}
