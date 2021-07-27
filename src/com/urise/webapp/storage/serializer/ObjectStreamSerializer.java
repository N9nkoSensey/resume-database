package com.urise.webapp.storage.serializer;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;

public class ObjectStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream outputStream) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(resume);
        }
    }

    @Override
    public Resume doRead(InputStream inputStream) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Resume) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}