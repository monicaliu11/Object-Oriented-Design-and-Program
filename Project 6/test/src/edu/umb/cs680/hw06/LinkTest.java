package edu.umb.cs680.hw06;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class LinkTest {
    LocalDateTime now = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, now);
    Directory system = new Directory(root, "system", 0, now);
    Directory home = new Directory(root, "home", 0, now);
    Directory pictures = new Directory(home, "pictures", 0, now);
    File a = new File(system, "a", 5, now);
    File b = new File(system, "b", 10, now);
    File c = new File(system, "c", 15, now);
    File d = new File(home, "d", 20, now);
    File e = new File(pictures, "e", 25, now);
    File f = new File(pictures, "f", 30, now);
    Link x = new Link(home, "x", 0, now, system);
    Link y = new Link(pictures, "y", 0, now, e);

    private String[] linkToStringArray(Link l) {
        if(l.getTarget().isDirectory()) {
            Directory directory = (Directory)l.getTarget();

            String[] linkInfo = {
                    String.valueOf(l.isDirectory()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),l.getName(),
                    Integer.toString(l.getSize()), l.getParent().getName(), Integer.toString(directory.countChildren()),
                    Integer.toString((l.getTotalSize())), l.getCreationTime().toString()
            };


            ArrayList<String> list = new ArrayList<String>(Arrays.asList(linkInfo));


            if(((Directory) l.getTarget()).getChildren()!= null) {
                LinkedList<FSElement> children = ((Directory) l.getTarget()).getChildren();
                for(FSElement f : children) {
                    list.add(f.getName());
                }

                LinkedList<Directory> dir = ((Directory) l.getTarget()).getSubDirectories();
                for (Directory d : dir) {
                    list.add(d.getName());
                }

                LinkedList<File> files = ((Directory) l.getTarget()).getFiles();
                for(File fi : files) {
                    list.add(fi.getName());
                }
            }


            return list.toArray(new String[]{});
        }
        else if(l.getTarget().isFile()) {
            File file = (File)l.getTarget();

            String[] linkInfo = { String.valueOf(l.isDirectory()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),
                    l.getName(), Integer.toString(l.getSize()), l.getParent().getName(), l.getCreationTime().toString()};
            return linkInfo;

        }
        else if(l.getTarget().isLink()){
            Link link = (Link)l.getTarget();

            String[] linkInfo = { String.valueOf(l.isDirectory()), String.valueOf(l.isFile()), String.valueOf(l.isLink()),
                    l.getName(), Integer.toString(l.getSize()), l.getParent().getName(), l.getCreationTime().toString()};
            return linkInfo;

        }
        else return null;
    }

    @Test
    void verifyLinkEqualityLinkx() {
        String [] expected = {"false", "false", "true", "x", "0", "home", "3", "30", now.toString(),"a", "b", "c",
        "a", "b", "c"};
        Link actual = x;
        assertArrayEquals(expected, this.linkToStringArray(actual));
    }

    @Test
    void verifyLinkEqualityLinky() {
        String[] expected = {"false", "false", "true", "y", "0", "pictures", now.toString()};
        Link actual = y;
        assertArrayEquals(expected, this.linkToStringArray(actual));
    }
}
