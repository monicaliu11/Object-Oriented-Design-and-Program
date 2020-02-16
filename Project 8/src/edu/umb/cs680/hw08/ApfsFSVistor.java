package edu.umb.cs680.hw08;

public interface ApfsFSVistor {
    public void visit(ApfsDirectory dir);

    public void visit(ApfsFile file);

    public void visit(ApfsLink link);
}
