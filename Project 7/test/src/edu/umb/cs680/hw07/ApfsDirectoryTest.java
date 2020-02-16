package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ApfsDirectoryTest {
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
   // ApfsLink x = new ApfsLink(home, "x", 0, now, system, "Qi", now);
    //ApfsLink y = new ApfsLink(pictures, "y", 0, now, e, "Qi", now);

    private String[] dirToStringArray(ApfsDirectory d) {

        if(d.parent != null) {
            String[] dirInfo = {
                    String.valueOf(d.isDirectroy()), d.getName(), Integer.toString(d.getSize()), d.getParent().getName(),
                    Integer.toString(d.countChildren()), Integer.toString((d.getTotalSize())), d.getCreationTime().toString(),
                    d.getOwnerName(), d.getLastModifiedTimestamp().toString()
            };
            return dirInfo;
        }
        else {
            String[] dirInfo = {
                    String.valueOf(d.isDirectroy()), d.getName(), Integer.toString(d.getSize()), "null",
                    Integer.toString(d.countChildren()), Integer.toString((d.getTotalSize())), d.getCreationTime().toString(),
                    d.getOwnerName(), d.getLastModifiedTimestamp().toString()
            };
            return dirInfo;
        }
    }

    @Test
    void verifyDirectoryEqualityRoot() {

        String[] expected = {"true", "/", "0", "null", "2", "105", now.toString(), "Qi", now.toString()};
        ApfsDirectory actual = root;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualitySystem() {

        String[] expected = {"true", "system", "0", "/", "3", "30", now.toString(),"Qi", now.toString()};
        ApfsDirectory actual = system;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualityHome() {

        String[] expected = {"true", "home", "0", "/", "2", "75", now.toString(),"Qi", now.toString()};
        ApfsDirectory actual = home;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

    @Test
    void verifyDirectoryEqualityPictures() {

        String[] expected = {"true", "pictures", "0", "home", "2", "55", now.toString(),"Qi", now.toString()};
        ApfsDirectory actual = pictures;
        assertArrayEquals(expected, this.dirToStringArray(actual));
    }

}
