package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage{

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume " + resume.getUuid() + " not exist.");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume " + resume.getUuid() + " already exist.");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1){
            System.out.println("Resume " + uuid + " not exist.");
        }else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }


    protected int getIndex(String uuid) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        return -1;
    }
}
