package com.joezhou.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author JoeZhou
 */
public class FileChannelTest {

    /**
     * copy `nio-src.txt` to `nio-dest.txt`
     */
    @Test
    public void fileChannel() throws IOException {
        String srcPath = "D:" + File.separator + "java-io" + File.separator + "nio-src.txt";
        String destPath = "D:" + File.separator + "java-io" + File.separator + "nio-dest.txt";
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int read = fisChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
        }
        fosChannel.close();
        fisChannel.close();
        fis.close();
        fos.close();
        System.out.println("copy over...");
    }
}
