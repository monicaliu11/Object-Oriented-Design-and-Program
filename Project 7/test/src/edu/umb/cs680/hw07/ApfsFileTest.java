package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ApfsFileTest {
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

    private String[] fileToStringArray(ApfsFile f) {

        String[] fileInfo = {
                String.valueOf(f.isFile()), f.getName(), Integer.toString(f.getSize()), f.getParent().getName(),
                f.getCreationTime().toString(), f.getOwnerName(), f.getLastModifiedTimestamp().toString()
        };
        return fileInfo;

    }

    @Test
    void verifyFileEqualityFilea() {

        String[] expected = {"true", "a", "5", "system", now.toString(), "Qi", now.toString()};
        ApfsFile actual = a;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFileb() {

        String[] expected = {"true", "b", "10", "system", now.toString(), "Qi", now.toString()};
        ApfsFile actual = b;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilec() {

        String[] expected = {"true", "c", "15", "system", now.toString(), "Qi", now.toString()};
        ApfsFile actual = c;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFiled() {

        String[] expected = {"true", "d", "20", "home", now.toString(), "Qi", now.toString()};
        ApfsFile actual = d;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilee() {

        String[] expected = {"true", "e", "25", "pictures", now.toString(), "Qi", now.toString()};
        ApfsFile actual = e;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

    @Test
    void verifyFileEqualityFilef() {

        String[] expected = {"true", "f", "30", "pictures", now.toString(), "Qi", now.toString()};
        ApfsFile actual = f;
        assertArrayEquals(expected, this.fileToStringArray(actual));
    }

}
