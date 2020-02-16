package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class ApfsCrawlingVistor implements ApfsFSVistor {
    private ArrayList<ApfsFile> files = new ArrayList<ApfsFile>();

    @Override
    public void visit(ApfsDirectory dir) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        this.files.add(file);
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    public ArrayList<ApfsFile> getFiles() {
        return this.files;
    }
}
