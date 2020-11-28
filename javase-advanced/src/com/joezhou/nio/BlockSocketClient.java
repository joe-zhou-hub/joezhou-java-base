package com.joezhou.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author JoeZhou
 */
public class BlockSocketClient {
    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 9999;
        SocketAddress socketAddress = new InetSocketAddress(ip, port);
        SocketChannel socketChannel = SocketChannel.open(socketAddress);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("please input your message...");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            byteBuffer.put(("=> " + str).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
            if ("exit".equalsIgnoreCase(str)) {
                break;
            }
        }
        br.close();
        socketChannel.close();
    }
}
