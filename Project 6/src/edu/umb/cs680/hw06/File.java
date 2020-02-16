package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File (Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.parent.appendChild(this);
    }

    @Override
    public boolean isFile() { return true; }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public int getTotalSize() { return this.getSize(); }
}
