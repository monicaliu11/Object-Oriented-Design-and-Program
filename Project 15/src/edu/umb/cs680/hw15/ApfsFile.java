package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                    String ownerName, LocalDateTime lastModifiedTimestamp) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTimestamp);
        this.parent.appendChild(this);
    }

    @Override
    public boolean isFile() { return true; }

    @Override
    public boolean isLink() {
        return false;
    }

    @Override
    public boolean isDirectroy() {
        return false;
    }

    @Override
    public int getTotalSize() { return this.getSize(); }

    @Override
    public void accept(ApfsFSVistor v) {
        v.visit(this);
    }
}
