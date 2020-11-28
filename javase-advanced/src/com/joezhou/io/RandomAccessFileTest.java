package com.joezhou.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 使用同一个RandomAccessFile对象对一个文件完成
 * 三个员工信息（姓名和年龄）的按顺序写和按顺序读，且在输出过程种，跳过赵四的年龄。
 *
 * @author JoeZhou
 */
public class RandomAccessFileTest {

    private RandomAccessFile randomAccessFile;

    @Before
    public void before() throws IOException {
        randomAccessFile = new RandomAccessFile("D:\\java\\io\\emp.txt", "rw");
        randomAccessFile.writeUTF("赵四");
        randomAccessFile.writeInt(18);
        randomAccessFile.writeUTF("刘能");
        randomAccessFile.writeInt(28);
        randomAccessFile.writeUTF("广坤");
        randomAccessFile.writeInt(38);
    }

    @After
    public void after() throws IOException {
        randomAccessFile.close();
    }

    @Test
    public void write() throws IOException {

        // 位置指示器重置于0号位
        randomAccessFile.seek(0);
        System.out.print(randomAccessFile.readUTF() + "\t");

        // 跳过赵四的年龄
        randomAccessFile.skipBytes(4);
        System.out.print(randomAccessFile.readUTF() + "\t");
        System.out.print(randomAccessFile.readInt() + "\t");
        System.out.print(randomAccessFile.readUTF() + "\t");
        System.out.print(randomAccessFile.readInt() + "\n");
    }

    @Test
    public void work01() throws IOException {
        randomAccessFile.seek(24);
        System.out.print(randomAccessFile.readUTF() + "\t");
        System.out.print(randomAccessFile.readInt() + "\t");
        randomAccessFile.seek(12);
        System.out.print(randomAccessFile.readUTF() + "\t");
        System.out.print(randomAccessFile.readInt() + "\t");
        randomAccessFile.seek(0);
        System.out.print(randomAccessFile.readUTF() + "\t");
        System.out.print(randomAccessFile.readInt() + "\n");
    }
}