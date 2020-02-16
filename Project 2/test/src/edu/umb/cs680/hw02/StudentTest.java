package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void testCreateInStateStudent () {
        Student cut = Student.createInStateStudent("Bob", "108 Washington Street, Boston, MA 02135", 10, "New York");
        String expect0 = "Bob";
        String actual0 = cut.getName();
        assertEquals(expect0, actual0);
        String expect1 = "108 Washington Street, Boston, MA 02135";
        String actual1 = cut.getUsAddr();
        assertEquals(expect1, actual1);
        int expect2 = 10;
        int actual2 = cut.getYrsInState();
        assertEquals(expect2, actual2);
        String expect3 = "New York";
        String actual3 = cut.getPriorState();
        assertEquals(expect3, actual3);
    }

    @Test
    public void testCreateOutStateStudent () {
        Student cut = Student.createInStateStudent("Jean", "11 Main Street, Boston, MA 02035", 1, "Texas");
        String expect0 = "Jean";
        String actual0 = cut.getName();
        assertEquals(expect0, actual0);
        String expect1 = "11 Main Street, Boston, MA 02035";
        String actual1 = cut.getUsAddr();
        assertEquals(expect1, actual1);
        int expect2 = 1;
        int actual2 = cut.getYrsInState();
        assertEquals(expect2, actual2);
        String expect3 = "Texas";
        String actual3 = cut.getPriorState();
        assertEquals(expect3, actual3);
    }

    @Test
    public void testCreateIntelStudent () {
        Student cut = Student.createIntelStudent("Wei Zhang", 3445,"88 Main Street, Boston, MA 02035", 0, "67 Gandong road, Fuzhou, China 344000");
        String expect0 = "Wei Zhang";
        String actual0 = cut.getName();
        assertEquals(expect0, actual0);
        int expect1 = 3445;
        int actual1 = cut.getI20num();
        assertEquals(expect1, actual1);
        String expect2 = "88 Main Street, Boston, MA 02035";
        String actual2 = cut.getUsAddr();
        assertEquals(expect2, actual2);
        int expect3 = 0;
        int actual3 = cut.getYrsInState();
        assertEquals(expect3, actual3);
        String expect4 = "67 Gandong road, Fuzhou, China 344000";
        String actual4 = cut.getForeignAddr();
        assertEquals(expect4, actual4);
    }

}
