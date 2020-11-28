package com.joezhou.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author JoeZhou
 */
public class FileTest {

    private File file;

    @Before
    public void before() throws IOException {
        String dirPath = "D:" + File.separator + "java-io";
        File dirs = new File(dirPath);
        if (!dirs.exists()) {
            System.out.println(dirs.mkdirs() ? "目录创建成功" : "目录创建失败");
        }
        String filePath = "start.txt";
        this.file = new File(dirPath, filePath);
        if (this.file.exists()) {
            System.out.println(this.file.delete() ? "文件删除成功" : "文件删除失败");
        }
        System.out.println(this.file.createNewFile() ? "文件创建成功" : "文件创建失败");
    }

    @Test
    public void fileApi() {
        System.out.println("文件名：" + file.getName());
        System.out.println("文件路径：" + file.getPath());
        System.out.println("文件大小：" + file.length());
        System.out.println("父目录：" + file.getParent());
        System.out.println("最后修改日期：" + new Date(file.lastModified()));
        System.out.println(file.canRead() ? "可读" : "不可读");
        System.out.println(file.canWrite() ? "可写" : "不可写");
        System.out.println(file.isFile() ? "是文件" : "不是文件");
        System.out.println(file.isDirectory() ? "是目录" : "不是目录");
        System.out.println(file.isHidden() ? "隐藏文件" : "非隐藏文件");
        System.out.println(file.isAbsolute() ? "是绝对路径" : "不是绝对路径");
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        File newFile = new File("D:\\java\\io\\build-1.txt");
        System.out.println(file.renameTo(newFile) ? "修改成功" : "修改失败");
        System.out.println(file.equals(newFile) ? "是同一个" : "非同一个");
    }
}