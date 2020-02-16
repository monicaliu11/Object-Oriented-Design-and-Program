package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    private LinkedList<ApfsElement> children;
    private LinkedList<ApfsFile> files;
    private LinkedList<ApfsDirectory> directories;
    private LinkedList<ApfsLink> links;
    private String ownerName;
    private LocalDateTime lastModifiedTimestamp;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                         String ownerName, LocalDateTime lastModifiedTimestamp) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTimestamp);
        setSize(0);
        this.children = new LinkedList<>();
        this.files = new LinkedList<>();
        this.directories = new LinkedList<>();
        this.links = new LinkedList<>();

        if(parent != null) {
            this.parent.appendChild(this);
        }
    }

    public LinkedList<ApfsElement> getChildren() {
        Collections.sort(this.children, new Comparator<FSElement>() {
            @Override
            public int compare(FSElement o1, FSElement o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return this.children;
    }

    public void appendChild(ApfsElement child) {
        if(child != null) {
            children.add(child);
        }

        if(child.isDirectroy()) {
            directories.add((ApfsDirectory) child);
        } else if (child.isFile()) {
            files.add((ApfsFile) child);
        } else {
            links.add((ApfsLink) child);
        }
    }


    public int countChildren() {
        return children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        Collections.sort(directories, new Comparator<ApfsDirectory>() {
            @Override
            public int compare(ApfsDirectory o1, ApfsDirectory o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return directories;
    }

    public LinkedList<ApfsFile> getFiles() {
        Collections.sort(files, new Comparator<ApfsFile>() {
            @Override
            public int compare(ApfsFile o1, ApfsFile o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return files;
    }

    public LinkedList<ApfsLink> getLinks() {
        return links;
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
    public boolean isDirectroy() {
        return true;
    }

    @Override
    public void accept(ApfsFSVistor v) {
        v.visit(this);
        for(ApfsDirectory dir : this.directories) {
            dir.accept(v);
        }
        for(ApfsFile file : this.files) {
            file.accept(v);
        }
        for(ApfsLink link : this.links) {
            link.accept(v);
        }
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        Collections.sort(children, comparator);
        return children;
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        Collections.sort(directories, comparator);
        return directories;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        Collections.sort(files, comparator);
        return files;
    }
}
