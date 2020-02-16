package edu.umb.cs680.hw15;

public abstract class FileSystem {

    protected String name;
    protected int capacity;
    protected int id;
    private FSElement root;

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if(root.isDirectroy() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    private void setRoot (FSElement root) { this.root = root; }

    public FSElement getRoot() { return this.root; }

    public int getCapacity() { return this.capacity; }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public int getUsed() { return root.getTotalSize(); }

    protected abstract FSElement createDefaultRoot();
}
