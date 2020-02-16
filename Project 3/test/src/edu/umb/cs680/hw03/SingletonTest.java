package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {
    @Test

    public void testSingleton () {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        String str = "umb";
        String expected = str;
        String actual = "umb0".substring(0,3);
//        assertSame(instance1, instance2);
//        assertEquals(instance1, instance2);
        assertSame(expected, actual);
        assertEquals(expected, actual);

    }

}
