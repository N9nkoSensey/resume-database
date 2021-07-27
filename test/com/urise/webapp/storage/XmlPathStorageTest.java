package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest{

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIRECTORY.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
