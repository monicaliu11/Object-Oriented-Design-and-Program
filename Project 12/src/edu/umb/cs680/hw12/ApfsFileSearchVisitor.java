package edu.umb.cs680.hw12;

import java.util.HashMap;

public class ApfsFileSearchVisitor implements ApfsFSVistor {
    private HashMap<String, ApfsFile> index = new HashMap<String, ApfsFile>();

    @Override
    public void visit(ApfsDirectory dir) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        index.put(file.getName(), file);
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    public HashMap<String, ApfsFile> getIndex() {
        return index;
    }
}
