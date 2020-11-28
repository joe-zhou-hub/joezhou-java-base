package com.joezhou.classloader;

import java.util.Scanner;

/**
 * @author JoeZhou
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        new ClassA();
        System.out.println("main...");
        new ClassB();
        new ClassC(); new ClassC();
        new ClassD(); new ClassD();
        System.out.println(Scanner.class);
    }
}

class ClassA { }

class ClassB { }

class ClassC {
    static { System.out.println("classC-static-block..."); }
}

class ClassD {
    static { System.out.println("classD-dynamic-block..."); }
}