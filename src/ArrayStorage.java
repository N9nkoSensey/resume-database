public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {

        int size = size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume resume) {

        boolean isClear = true;
        if (resume != null && size() < storage.length) {
            for (int i = 0; i < size(); i++) {
                if (resume.uuid.equals(storage[i].uuid)) {
                    isClear = false;
                    System.out.println("Duplicate resume");
                    break;
                }
            }
            if (isClear) {
                storage[size()] = resume;
            }
        } else {
            System.out.println("Can't execute method \"save\". Either an empty summary or an array filled");
        }
    }

    Resume get(String uuid) {

        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size(); i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {

        int size = size();
        if (uuid != null || !uuid.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                }

                if (storage[i] == null && storage[i + 1] != null && i != (storage.length - 1)) {
                    storage[i] = storage[i + 1];
                    storage[i + 1] = null;
                }
            }
        }
    }

    Resume[] getAll() {

        Resume[] resumesWithoutNull = new Resume[size()];
        if (size() >= 0) System.arraycopy(storage, 0, resumesWithoutNull, 0, size());
        return resumesWithoutNull;
    }

    int size() {

        if (storage[storage.length - 1] != null) {
            return storage.length;
        }

        int storageSize = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storageSize = i;
                break;
            }
        }

        return storageSize;
    }
}
