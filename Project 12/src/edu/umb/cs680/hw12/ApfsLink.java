package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target,
                    String ownerName, LocalDateTime lastModifiedTimestamp) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTimestamp);
        this.target = target;
        setSize(0);
        this.parent.appendChild(this);
    }

    @Override
    public boolean isFile() { return false; }

    @Override
    public boolean isLink() { return true; }

    @Override
    public boolean isDirectroy() {
        return false;
    }

    @Override
    public int getTotalSize() { return this.target.getTotalSize(); }

    @Override
    public void accept(ApfsFSVistor v) {
        v.visit(this);
    }

    public ApfsElement getTarget() { return this.target; }

}
