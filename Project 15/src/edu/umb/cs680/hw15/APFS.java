package edu.umb.cs680.hw15;


import java.time.LocalDateTime;

public class APFS extends FileSystem {

    private ApfsDirectory root;
    private APFS () {};
    private static APFS instance = null;

    public static APFS getAPFS() {
        if(instance == null) {
            instance = new APFS();
        }
        return instance;
    }

    protected FSElement createDefaultRoot(){
        root = new ApfsDirectory(null,"/", 0, LocalDateTime.now(), "Qi", LocalDateTime.now());
        return root;
    }

    public ApfsDirectory getRootDir() {
        return this.root;
    }

    public void setRootDir(ApfsDirectory dir) {
        this.root = dir;
    }

}
