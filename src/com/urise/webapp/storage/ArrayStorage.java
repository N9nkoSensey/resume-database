package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume " + resume.getUuid() + " not exist.");
        } else {
            storage[index] = resume;
            size++;
        }
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1){
            System.out.println("Resume " + resume.getUuid() + " already exist.");
        }else if (size == storage.length){
            System.out.println("Storage overflow");
        } else{
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                    storage[i] = null;
                    size--;
                }

                if (storage[i] == null && storage[i + 1] != null && i != (storage.length - 1)) {
                    storage[i] = storage[i + 1];
                    storage[i + 1] = null;
                }
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
