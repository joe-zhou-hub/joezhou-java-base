package com.joezhou.io;

import org.junit.Test;

import java.io.*;

/**
 * @author JoeZhou
 */
public class TransformSeriesTest {

    private static void inputStreamReader() {
        // System.in is typeof InputStream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            while ((str = br.readLine()) != null) {
                if ("exit".equals(str)) {
                    break;
                }
                System.out.println(">> " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设计模拟Scanner读取控制台信息的方法，要求输入 `exit` 时可以退出。
     * IDEA中的Junit和System.in或者Scanner有冲突，需要换成main方法测试
     */
    public static void main(String[] args) {
        inputStreamReader();
    }

    /**
     * 向文件中写入一个UTF8的 "你好" 和一个 GBK的 "世界"
     */
    @Test
    public void outputStreamWriter() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "hello.txt";
        OutputStreamWriter osw = null;
        try {
            FileOutputStream fos = new FileOutputStream(destPath);
            osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write("你好");
            System.out.println(osw.getEncoding());
            osw.flush();
            osw = new OutputStreamWriter(fos, "GBK");
            osw.write("世界");
            System.out.println(osw.getEncoding());
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
