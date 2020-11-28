package com.joezhou.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PrintTest {

    @Test
    public void print() {

        // hot-key: "sout" > tab
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");

        System.out.print(1);
        System.out.print(2);
        System.out.print(3);
    }

    @Test
    public void splicingString() {
        System.out.println("1" + 2 + 3 + "4" + "5");
    }

    @Test
    public void printf() {
        System.out.printf("%s, %d, %.2f", "a", 10, 12.5678);
    }

    @Test
    public void escapeCharacter() {
        System.out.println("hello\nworld");
        System.out.println("hello\tworld");
        System.out.println("hello\0world");
        System.out.println("\u5468");

        System.out.println("hello\\nworld");
        System.out.println("hello\\tworld");
        System.out.println("hello\\0world");
        System.out.println("\\u5468");

        System.out.println("\"");
        System.out.println("\'");
        System.out.println("\\");
    }

    @Test
    public void errorPrint() {
        System.err.printf("printf: %s\n", "hello!");
        System.err.println("println: hello!");
        System.err.print("print: hello!\n");
    }
}
