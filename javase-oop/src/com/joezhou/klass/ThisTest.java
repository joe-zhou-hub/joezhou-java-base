package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ThisTest {
    @Test
    public void thisConstructor() {
        new ThisDemo();
        new ThisDemo("刘能");
    }
}

class ThisDemo {
    private String name;

    public ThisDemo() {
        this("赵四");
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThisDemo(String str) {
        System.out.println("姓名为：" + str);
    }
}
