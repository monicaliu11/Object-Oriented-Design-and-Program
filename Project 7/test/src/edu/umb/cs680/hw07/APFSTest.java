package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;

public class APFSTest {



    @Test
    public void testSingleton() {
        APFS instance1 = APFS.getAPFS();
        APFS instance2 = APFS.getAPFS();
        assertSame(instance1, instance2);
    }

    @Test
    public void testCreateDefaultRoot() {
        APFS apfs = APFS.getAPFS();
        FSElement root = apfs.createDefaultRoot();
        Assertions.assertEquals("/", root.getName());
        Assertions.assertEquals(0, root.getSize());
    }
}
