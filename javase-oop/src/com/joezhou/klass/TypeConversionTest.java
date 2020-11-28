package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class TypeConversionTest {
    @Test
    public void typeConversion() {
        // 动态绑定：不运行不知道到底new个什么
        Fu fu = new Zi();

        // 具体调用的是哪个方法，看等号右边（运行时类型）
        fu.method();

        // 具体调用的是哪个属性，看等号左边（编译时类型）
        System.out.println(fu.name);
    }
}

class Fu {
    public String name = "fu";

    public void method() {
        System.out.println("method in Fu...");
    }
}

class Zi extends Fu {
    public String name = "zi";

    @Override
    public void method() {
        System.out.println("method in Zi...");
    }
}
