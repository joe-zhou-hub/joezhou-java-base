package com.joezhou.io;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author JoeZhou
 */
public class BufferedSeriesTest {

    private String filePath = "D:" + File.separator + "java-io" + File.separator + "HelloWorld.java";

    /**
     * 对 `HelloWorld.java` 文件进行中间部分内容读取12-3456-3456
     */
    @Test
    public void bufferedInputStream() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath), 5)) {
            System.out.println("pos-01：" + (char) bis.read());
            System.out.println("pos-02：" + (char) bis.read());
            bis.mark(4);
            System.out.println("pos-03：" + (char) bis.read());
            System.out.println("pos-04：" + (char) bis.read());
            System.out.println("pos-05：" + (char) bis.read());
            System.out.println("pos-06：" + (char) bis.read());
            System.out.println("pos-06：" + (char) bis.read());
            bis.reset();
            System.out.println("pos-03：" + (char) bis.read());
            System.out.println("pos-04：" + (char) bis.read());
            System.out.println("pos-05：" + (char) bis.read());
            System.out.println("pos-06：" + (char) bis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对一个文件写入10个A
     */
    @Test
    public void bufferedOutputStream() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "io.txt";
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {
            int times = 10;
            for (int i = 0; i < times; i++) {
                bos.write('B');
            }
            System.out.println("write over...");
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一行一行地读取 `HelloWorld.java` 文件，并打印在控制台上
     */
    @Test
    public void bufferedReader() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定文件写入100个随机数，每个随机数占据一行
     */
    @Test
    public void bufferedWriter() {
        String filePath = "D:" + File.separator + "java-io" + File.separator + "random.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0, j = 100; i < j; i++) {
                bw.write("随机数：" + (random.nextInt(100)));
                bw.newLine();
            }
            System.out.println("write over...");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
