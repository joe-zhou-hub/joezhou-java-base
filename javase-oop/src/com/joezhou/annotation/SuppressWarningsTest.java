package com.joezhou.annotation;

/**
 * @author JoeZhou
 */
public class SuppressWarningsTest {
    @SuppressWarnings(value = "unused")
    public void warning() {
        int num = 10;
    }
}
