package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ApfsReverseAlphabeticalTest {

    @Test
    public void sorting() {
        ApfsDirectory root = new ApfsDirectory(null,
                "/", 0,
                LocalDateTime.now(), "Qi", LocalDateTime.now());

        LocalDateTime now = LocalDateTime.now();
        ApfsFile fileA = new ApfsFile(root, "a", 5, now, "Qi", now);
        ApfsFile fileB = new ApfsFile(root, "b", 5, now, "Qi", now);

        LinkedList<ApfsFile> files = root.getFiles(new ReverseAlphabeticalComparator());
        assertSame(files.get(0), fileB);
        assertSame(files.get(1), fileA);
    }
}
