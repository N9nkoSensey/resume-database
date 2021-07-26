package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.File;
import java.util.List;

public class AbstractFileStorage extends AbstractStorage<File>{
    @Override
    protected File getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected void doUpdate(Resume resume, File searchKey) {

    }

    @Override
    protected boolean isExist(File searchKey) {
        return false;
    }

    @Override
    protected void doSave(Resume resume, File searchKey) {

    }

    @Override
    protected Resume doGet(File searchKey) {
        return null;
    }

    @Override
    protected void doDelete(File searchKey) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
