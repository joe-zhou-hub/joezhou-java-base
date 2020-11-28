package com.joezhou.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author JoeZhou
 */
public class BufferTest {

    @Test
    public void build() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.isDirect() ? "direct..." : "heap...");
    }

    @Test
    public void coreAttributes() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.position(0).limit(1024);
        System.out.println("capacity: " + byteBuffer.capacity());
        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit: " + byteBuffer.limit());
    }

    @Test
    public void bufferApi() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello".getBytes(), 0, 5);
        byteBuffer.put("world".getBytes());
        System.out.println("data: " + new String(byteBuffer.array()));

        byteBuffer.flip();
        System.out.print("flip: ");
        System.out.print((char) byteBuffer.get(3));
        System.out.print((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());

        byteBuffer.rewind();
        System.out.print("rewind: ");
        System.out.print((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());

        byteBuffer.clear();
        System.out.print("clear: ");
        System.out.print((char) byteBuffer.get());
        System.out.println((char) byteBuffer.get());

        System.out.print("remaining: ");
        if (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining());
        }
    }
}
