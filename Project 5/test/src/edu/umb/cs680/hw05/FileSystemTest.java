package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertSame;

public class FileSystemTest {
    @Test
    public void singletonTest() {
        FileSystem instance1 = FileSystem.getFileSystem();
        FileSystem instance2 = FileSystem.getFileSystem();
        assertSame(instance1, instance2);
    }

    @Test
    public void addAndGetTest() {
        FileSystem file = FileSystem.getFileSystem();
        LocalDateTime now = LocalDateTime.now();
        Directory root = new Directory(null, "root", 0, now);

        file.addRootDirs(root);
        Directory expect = root;
        Directory actual = file.getRootDirs().get(0);

    }
}
