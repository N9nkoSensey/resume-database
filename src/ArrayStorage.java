public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public boolean update(Resume resume) {
        if (resume != null && size < storage.length) {
            for (int i = 0; i < size; i++) {
                if (resume.uuid.equals(storage[i].uuid)) {
                    System.out.println("Duplicate resume");
                    return false;
                }
            }
        } else {
            System.out.println("Can't execute method \"save\". Either an empty summary or an array filled");
        }
        return true;
    }

    public void save(Resume resume) {
        if (update(resume)) {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (storage[i] != null && storage[i].uuid.equals(uuid)) {
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
