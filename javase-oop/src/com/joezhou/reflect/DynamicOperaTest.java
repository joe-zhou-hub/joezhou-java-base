package com.joezhou.reflect;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 先在D盘创建一个HelloWorld.java文件
 *
 * @author JoeZhou
 */
public class DynamicOperaTest {

    @Test
    public void dynamicCompile() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String filePath = "D:" + File.separator + "HelloWorld.java";
        int result = compiler.run(null, null, null, filePath);
        System.out.println(result == 0 ? "compile success" : "compile fail");
    }

    @Test
    public void dynamicRun() throws Exception {
        URL url = new URL("file:" + File.separator + "D:" + File.separator);
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        Class<?> klass = urlClassLoader.loadClass("HelloWorld");
        Method method = klass.getMethod("main", String[].class);
        /*
            Use `Object` instead of `String[]`
            Because `new String[]{"a", "b"}` will be split into two parameters: "a" and "b"
            The two parameters are wrong for main()
        */
        method.invoke(null, (Object) new String[]{"a", "b"});
        urlClassLoader.close();
    }
}