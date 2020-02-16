package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {

    private String ownerName;
    private LocalDateTime lastModifiedTimestamp;
    protected ApfsDirectory parent;

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                       String ownerName, LocalDateTime lastModifiedTimestamp) {
        super(name, size, creationTime);
        this.parent = parent;
        this.ownerName = ownerName;
        this.lastModifiedTimestamp = lastModifiedTimestamp;

    }

    public ApfsDirectory getParent() {
        return parent;
    }

    public String getOwnerName() { return ownerName; }

    public LocalDateTime getLastModifiedTimestamp() { return lastModifiedTimestamp; }

    public abstract boolean isDirectroy();

    public abstract void accept(ApfsFSVistor v);

}
