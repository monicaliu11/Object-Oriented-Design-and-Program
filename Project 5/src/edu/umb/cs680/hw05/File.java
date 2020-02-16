package edu.umb.cs680.hw05;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File (Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        this.parent.appendChild(this);
    }

    public boolean isFile() { return true; }

    public int getTotalSize() { return this.getSize(); }
}
