package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public boolean update(Resume resume) {
        if (resume != null) {
            for (int i = 0; i < size; i++) {
                if (resume.getUuid().equals(storage[i].getUuid())) {
                    System.out.println("Duplicate resume");
                    return false;
                }
            }
        } else {
            System.out.println("The resume is empty.");
            return false;
        }
        return true;
    }

    public void save(Resume resume) {
        if (update(resume) && (size < storage.length)) {
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
        Resume[] resumesWithoutNull = new Resume[size];
        if (size > 0) System.arraycopy(storage, 0, resumesWithoutNull, 0, size);
        return resumesWithoutNull;
    }

    public int size() {
        return size;
    }
}
