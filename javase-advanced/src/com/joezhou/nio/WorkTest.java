package com.joezhou.nio;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * @author JoeZhou
 */
public class WorkTest {

    @Test
    public void markAndReset() {
        String str = "encoder";
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put(str);
        charBuffer.flip();
        charBuffer.position(2).mark();
        System.out.print(charBuffer.get());
        System.out.print(charBuffer.get());
        charBuffer.reset();
        System.out.print(charBuffer.get());
        System.out.print(charBuffer.get());
    }

}
