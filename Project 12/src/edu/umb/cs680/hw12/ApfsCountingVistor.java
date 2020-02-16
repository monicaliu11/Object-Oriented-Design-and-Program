package edu.umb.cs680.hw12;

public class ApfsCountingVistor implements ApfsFSVistor{
    private int dirNum;
    private int fileNum;
    private int linkNum;

    public void visit(ApfsDirectory dir){
        dirNum++;
    }

    public void visit(ApfsFile file) {
        fileNum++;
    }

    public void visit(ApfsLink link) {
        linkNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }
}
