package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirectoryTest {

    LocalDateTime now = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, now);
    Directory system = new Directory(root, "system", 0, now);
    Directory home = new Directory(root, "home", 0, now);
    Directory picture = new Directory(home, "picture", 0, now);
    File a = new File(system, "a", 5, now);
    File b = new File(system, "b", 10, now);
    File c = new File(system, "c", 15, now);
    File d = new File(home, "d", 20, now);
    File e = new File(picture, "e", 25, now);
    File f = new File(picture, "f", 30, now);

    private String[] dirToStringArray(Directory d) {

        if(d.parent != null) {
            String[] dirInfo = {
                    String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()), d.getParent().getName(),
                    Integer.toString(d.countChildren()), Integer.toString((d.getTotalSize())), d.getCreationTime().toString()
            };
            return dirInfo;
        }
        else {
            String[] dirInfo = {
                    String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()), "null",
                    Integer.toString(d.countChildren()), Integer.toString((d.getTotalSize())), d.getCreationTime().toString()
            };
            return dirInfo;
        }
    }

    @Test
    void verifyDirectoryEqualityRoot() {

        String[] expected = {"false", "root", "0", "null", "2", "105", now.toString()};
        Directory actual = root;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualitySystem() {

        String[] expected = {"false", "system", "0", "root", "3", "30", now.toString()};
        Directory actual = system;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualityHome() {

        String[] expected = {"false", "home", "0", "root", "2", "75", now.toString()};
        Directory actual = home;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualityPicture() {

        String[] expected = {"false", "picture", "0", "home", "2", "55", now.toString()};
        Directory actual = picture;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

}


