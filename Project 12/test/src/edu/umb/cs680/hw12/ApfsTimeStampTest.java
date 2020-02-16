package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ApfsTimeStampTest {
    @Test
    public void sorting() throws InterruptedException {
        ApfsDirectory root = new ApfsDirectory(null,
                "/", 0,
                LocalDateTime.now(), "Qi", LocalDateTime.now());

        LocalDateTime early = LocalDateTime.now();
        Thread.sleep(100);
        LocalDateTime late = LocalDateTime.now();
        ApfsFile fileA = new ApfsFile(root, "a", 5, late, "Qi", late);
        ApfsFile fileB = new ApfsFile(root, "b", 5, early, "Qi", early);

        LinkedList<ApfsFile> files = root.getFiles(new TimeStampComparator());
        assertSame(files.get(0), fileB);
        assertSame(files.get(1), fileA);
    }
}
