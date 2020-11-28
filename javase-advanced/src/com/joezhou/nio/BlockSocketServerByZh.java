package com.joezhou.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author JoeZhou
 */
public class BlockSocketServerByZh {
    public static void main(String[] args) throws IOException {
        int port = 9001;
        SocketAddress socketAddress = new InetSocketAddress(port);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(socketAddress);
        System.out.println("ready to accept data...");
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
            for (int i = 0, j = charBuffer.limit(); i < j; i++) {
                System.out.print(charBuffer.get());
            }
            System.out.println();
            byteBuffer.clear();
        }
        socketChannel.close();
        serverSocketChannel.close();
    }
}
