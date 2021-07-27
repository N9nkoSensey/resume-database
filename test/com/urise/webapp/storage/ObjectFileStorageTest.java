package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest{

    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIRECTORY, new ObjectStreamSerializer()));
    }
}
