package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ApfsLinkTest {
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

    private String[] linkToStringArray(ApfsLink l) {
        if(l.getTarget().isDirectroy()) {
            ApfsDirectory directory = (ApfsDirectory)l.getTarget();

            String[] linkInfo = {
                    String.valueOf(l.isDirectroy()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),l.getName(),
                    Integer.toString(l.getSize()), l.getParent().getName(), Integer.toString(directory.countChildren()),
                    Integer.toString((l.getTotalSize())), l.getCreationTime().toString()
            };


            ArrayList<String> list = new ArrayList<String>(Arrays.asList(linkInfo));


            if(((ApfsDirectory) l.getTarget()).getChildren()!= null) {
                LinkedList<FSElement> children = ((ApfsDirectory) l.getTarget()).getChildren();
                for(FSElement f : children) {
                    list.add(f.getName());
                }

                LinkedList<ApfsDirectory> dir = ((ApfsDirectory) l.getTarget()).getSubDirectories();
                for (ApfsDirectory d : dir) {
                    list.add(d.getName());
                }

                LinkedList<ApfsFile> files = ((ApfsDirectory) l.getTarget()).getFiles();
                for(ApfsFile fi : files) {
                    list.add(fi.getName());
                }
            }


            return list.toArray(new String[]{});
        }
        else if(l.getTarget().isFile()) {
            ApfsFile file = (ApfsFile)l.getTarget();

            String[] linkInfo = { String.valueOf(l.isDirectroy()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),
                    l.getName(), Integer.toString(l.getSize()), l.getParent().getName(), l.getCreationTime().toString()};
            return linkInfo;

        }
        else if(l.getTarget().isLink()){
            ApfsLink link = (ApfsLink)l.getTarget();

            String[] linkInfo = { String.valueOf(l.isDirectroy()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),
                    l.getName(), Integer.toString(l.getSize()), l.getParent().getName(), l.getCreationTime().toString()};
            return linkInfo;

        }
        else return null;
    }

    @Test
    public void verifyLinkEqualityLinkx() {
        String [] expected = {"false", "false", "true", "x", "0", "home", "3", "30", now.toString(),"a", "b", "c",
                "a", "b", "c"};
        ApfsLink actual = x;
        assertArrayEquals(expected, this.linkToStringArray(actual));
    }

    @Test
    public void verifyLinkEqualityLinky() {
        String[] expected = {"false", "false", "true", "y", "0", "pictures", now.toString()};
        ApfsLink actual = y;
        assertArrayEquals(expected, this.linkToStringArray(actual));
    }
}
