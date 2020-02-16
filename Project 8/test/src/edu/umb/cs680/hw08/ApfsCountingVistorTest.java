package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class ApfsCountingVistorTest {
    LocalDateTime now = LocalDateTime.now();

    ApfsDirectory root = new ApfsDirectory(null, "/", 0, now, "Qi", now);
    ApfsDirectory system = new ApfsDirectory(root, "system", 0, now, "Qi", now);
    ApfsDirectory home = new ApfsDirectory(root, "home", 0, now, "Qi", now);
    ApfsDirectory pictures = new ApfsDirectory(home, "pictures", 0, now, "Qi", now);
    ApfsFile a = new ApfsFile(system, "a", 5, now, "Qi", now);
    ApfsFile b = new ApfsFile(system, "b", 10, now, "Qi", now);
    ApfsFile c = new ApfsFile(system, "c", 15, now, "Qi", now);
    ApfsFile d = new ApfsFile(home, "d", 20, now, "Qi", now);
    ApfsFile e = new ApfsFile(pictures, "e", 25, now, "Qi", now);
    ApfsFile f = new ApfsFile(pictures, "f", 30, now, "Qi", now);
    ApfsLink x = new ApfsLink(home, "x", 0, now, system, "Qi", now);
    ApfsLink y = new ApfsLink(pictures, "y", 0, now, e, "Qi", now);

    private String[] intToStringArray(ApfsCountingVistor vistor) {
        root.accept(vistor);
        String[] countInfor = { vistor.getDirNum()+"", vistor.getFileNum()+"", vistor.getLinkNum()+""};
        return countInfor;

    }

    @Test
    void testVistor() {
        ApfsCountingVistor actual = new ApfsCountingVistor();
        String[] expected = {"4" , "6" , "2" };
        assertArrayEquals(expected, intToStringArray(actual));
    }
}
