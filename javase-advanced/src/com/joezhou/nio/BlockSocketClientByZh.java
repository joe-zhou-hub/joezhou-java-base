package com.joezhou.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author JoeZhou
 */
public class BlockSocketClientByZh {
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        int port = 9001;
        SocketAddress socketAddress = new InetSocketAddress(ip, port);
        SocketChannel socketChannel = SocketChannel.open(socketAddress);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        System.out.println("please input your message...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_8.newEncoder();
        String str;
        while ((str = br.readLine()) != null) {
            charBuffer.put("=> " + str);
            charBuffer.flip();
            ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
            socketChannel.write(byteBuffer);
            charBuffer.clear();
        }
        br.close();
        socketChannel.close();
    }
}
