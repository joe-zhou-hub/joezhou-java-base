package com.joezhou.io;

import org.junit.Test;

import java.io.*;

/**
 * @author JoeZhou
 */
public class DataSeriesTest {

    private String filePath = "D:" + File.separator + "java-io" + File.separator + "a.txt";

    /**
     * 将一个int，一个boolean和一个double写入文件 `data.txt`
     */
    @Test
    public void dataOutputStream() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeInt(250);
            dos.writeBoolean(true);
            dos.writeDouble(3.14);
            dos.flush();
            System.out.println("write over...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将 `data.txt` 读出来
     */
    @Test
    public void dataInputStream() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
