package com.joezhou.io;

import org.junit.Test;

import java.io.*;

/**
 * @author JoeZhou
 */
public class FileSeriesTest {

    private String filePath = "D:" + File.separator + "java-io" + File.separator + "HelloWorld.java";

    /**
     * 将 `HelloWorld.java` 内容输入到程序中并打印在控制台，并计算总字节数
     */
    @Test
    public void fileInputStream() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println("total bytes：" + fis.available());

            // temp var
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将 `HelloWorld.java` 内容copy到 `HelloWorld.txt`
     */
    @Test
    public void fileOutputStream() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "HelloWorld.txt";
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(destPath, true)) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            fos.flush();
            System.out.println("copy over...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将包含中文的 `HelloWorld.java` 输入到程序中并打印在控制台
     */
    @Test
    public void fileReader() {
        try (FileReader fr = new FileReader(filePath)) {
            System.out.println(fr.getEncoding());
            int b;
            while ((b = fr.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出一个文件 `Unicode.dat`，包含65536个Unicode字符
     */
    @Test
    public void fileWriter() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "Unicode.dat";
        try (FileWriter fw = new FileWriter(destPath)) {
            int unicodeMaxLength = 65535;
            for (int i = 0; i < unicodeMaxLength; i++) {
                fw.write(i);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
