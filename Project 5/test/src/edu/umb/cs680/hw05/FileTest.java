package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileTest {
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

    private String[] dirToStringArray(File f) {

        String[] dirInfo = {
                String.valueOf(f.isFile()), f.getName(), Integer.toString(f.getSize()), f.getParent().getName(),
                f.getCreationTime().toString()
        };
        return dirInfo;

    }

    @Test
    void verifyFileEqualityFilea() {

        String[] expected = {"true", "a", "5", "system", now.toString()};
        File actual = a;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFileb() {

        String[] expected = {"true", "b", "10", "system", now.toString()};
        File actual = b;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilec() {

        String[] expected = {"true", "c", "15", "system", now.toString()};
        File actual = c;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFiled() {

        String[] expected = {"true", "d", "20", "home", now.toString()};
        File actual = d;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilee() {

        String[] expected = {"true", "e", "25", "picture", now.toString()};
        File actual = e;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilef() {

        String[] expected = {"true", "f", "30", "picture", now.toString()};
        File actual = f;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

}
