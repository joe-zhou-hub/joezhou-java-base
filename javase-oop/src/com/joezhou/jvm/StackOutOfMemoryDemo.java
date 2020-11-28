package com.joezhou.jvm;

/**
 * @author JoeZhou
 */
public class StackOutOfMemoryDemo {
    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                while (true) {
                    System.out.println("go!");
                }
            }).start();
        }
    }
}
