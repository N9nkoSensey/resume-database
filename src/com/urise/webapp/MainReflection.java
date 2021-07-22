package com.urise.webapp;


import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Class<? extends Resume> resumeClass = resume.getClass();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        field.set(resume, "new_uuid");
        System.out.println(resume);

        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(resume);
        System.out.println(result);
    }
}
