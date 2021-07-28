package com.urise.webapp;

import java.io.*;
import java.util.Properties;

public class Config {
    private static final File PROPS = new File("config\\resumes.properties");
    private static final Config INSTANCE = new Config();
    private Properties properties = new Properties();
    private File storageDir;

    private Config(){
        try (InputStream inputStream = new FileInputStream(PROPS)){
            properties.load(inputStream);
            storageDir = new File(properties.getProperty("storage.dir"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS.getAbsolutePath());
        }
    }

    public static Config get(){
        return INSTANCE;
    }

    public File getStorageDir() {
        return storageDir;
    }
}
