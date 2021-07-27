package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest{

    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIRECTORY.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}
