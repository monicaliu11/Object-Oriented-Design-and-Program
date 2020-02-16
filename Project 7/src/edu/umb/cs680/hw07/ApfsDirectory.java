package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

        private LinkedList<FSElement> children;
        private LinkedList<ApfsFile> files;
        private LinkedList<ApfsDirectory> directories;
        private LinkedList<ApfsLink> links;
        private String ownerName;
        private LocalDateTime lastModifiedTimestamp;

        public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                             String ownerName, LocalDateTime lastModifiedTimestamp) {
            super(parent, name, size, creationTime, ownerName, lastModifiedTimestamp);
            setSize(0);
            this.children = new LinkedList<FSElement>();
            this.files = new LinkedList<ApfsFile>();
            this.directories = new LinkedList<ApfsDirectory>();
            this.links = new LinkedList<ApfsLink>();

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

            return directories;
        }

        public LinkedList<ApfsFile> getFiles() {

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

}
