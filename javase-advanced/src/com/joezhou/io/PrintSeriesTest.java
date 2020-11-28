package com.joezhou.io;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @author JoeZhou
 */
public class PrintSeriesTest {

    /**
     * 重新定义打印语句的目标位置为硬盘文件，并打印Unicode前128个字符，并还原
     */
    @Test
    public void printStream() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "ps.dat";
        try (PrintStream ps = new PrintStream(new FileOutputStream(destPath), true)) {
            PrintStream defaultOut = System.out;
            System.setOut(ps);
            int max = 128;
            for (int i = 0; i < max; i++) {
                System.out.print((char) i + " ");
            }
            System.setOut(defaultOut);
            System.out.println("print over...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设计一个模拟Log4j（java的日志文件）工作的方法
     */
    @Test
    public void printWriter() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "my-log.log";
        try (PrintWriter pw = new PrintWriter(new FileWriter(destPath, true), true)) {
            String msg01 = "添加了一个用户";
            String msg02 = "修改了一个用户";
            String msg03 = "删除了一个用户";
            pw.println(msg01);
            pw.println(msg02);
            pw.println(msg02);
            pw.println("LOGGING AT " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
