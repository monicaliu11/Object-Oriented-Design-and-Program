package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children;
    private LinkedList<File> files;
    private LinkedList<Directory> directories;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        setSize(0);
        this.children = new LinkedList<FSElement>();
        this.files = new LinkedList<File>();
        this.directories = new LinkedList<Directory>();
        if(parent != null) {
            this.parent.appendChild(this);
        }
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        if(child != null) {
            children.add(child);
        }
    }

    public int countChildren() {
        return children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        if(children != null) {
            for(FSElement child  : children) {
                if(child.isFile() == false)
                    directories.add((Directory) child);
            }
        }
        return directories;
    }

    public LinkedList<File> getFiles() {
        if(children != null){
            for(FSElement child : children) {
                if(child.isFile() == true) {
                    files.add((File) child);
                }
            }
        }
        return files;
    }

    @Override
    public int getTotalSize() {
        int totalSize = 0;
        if(children != null) {
            for(FSElement child : children) {
                totalSize += child.getTotalSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}

