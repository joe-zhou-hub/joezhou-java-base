package com.joezhou.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ByteArraySeriesTest {

    /**
     * 在内存中创造一个虚拟的字节数组，向字节数组中练习写入 `100`, `101`, `102`，计算长度，并读出所有数。
     */
    @Test
    public void byteArrayStream() {
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        try {
            baos = new ByteArrayOutputStream();
            baos.write(100);
            baos.write(101);
            baos.write(102);
            System.out.println("the length of baosData：" + baos.size());
            baos.flush();

            byte[] byteArray = baos.toByteArray();
            bais = new ByteArrayInputStream(byteArray);
            System.out.println(bais.read());
            System.out.println(bais.read());
            System.out.println(bais.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}