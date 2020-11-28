package com.joezhou.exception;

import org.junit.Test;

import javax.xml.ws.WebServiceException;
import java.io.Closeable;

/**
 * @author JoeZhou
 */
public class TryWithTest {

    private static class Person implements Closeable {
        @Override
        public void close() throws WebServiceException {
            System.out.println("Person的close()被调用...");
        }
    }

    @Test
    public void tryWithResources() {
        try (Person person = new Person()) {}
    }
}
