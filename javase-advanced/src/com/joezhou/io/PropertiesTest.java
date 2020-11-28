package com.joezhou.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author JoeZhou
 */
public class PropertiesTest {

    private static class Student {
        public void studentInfo() {
            System.out.println("Im a Student...");
        }
    }

    private static class Teacher {
        public void teacherInfo() {
            System.out.println("Im a Teacher...");
        }
    }

    @Test
    public void properties() throws Exception {
        Properties properties = new Properties();
        String fileName = "u02-oop" + File.separator + "src" + File.separator + "config.txt";
        FileReader fr = new FileReader(fileName);
        properties.load(fr);
        fr.close();
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class<?> klass = Class.forName(className);
        Object instance = klass.getDeclaredConstructor().newInstance();
        klass.getDeclaredMethod(methodName).invoke(instance);
    }
}

