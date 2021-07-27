package com.urise.webapp.storage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest{

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(STORAGE_DIRECTORY.getAbsolutePath()));
    }
}
