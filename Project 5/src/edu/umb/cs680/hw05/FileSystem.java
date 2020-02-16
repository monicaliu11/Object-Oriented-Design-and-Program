package edu.umb.cs680.hw05;

import java.util.LinkedList;

public class FileSystem {
    private static Directory rootDir;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<Directory>();
    }

    private static FileSystem instance = null;

    public static FileSystem getFileSystem() {
        if(instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public void addRootDirs(Directory rootDir) {
        this.rootDirs.add(rootDir);
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }
}
