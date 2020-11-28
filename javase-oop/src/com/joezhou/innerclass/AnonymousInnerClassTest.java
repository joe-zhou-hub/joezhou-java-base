package com.joezhou.innerclass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class AnonymousInnerClassTest {
    @Test
    public void baseServiceByInnerClass() {
        new BaseService() {
            @Override
            public void create() {
                System.out.println("添加...");
            }
        }.create();
    }

    @Test
    public void userServiceByInnerClass() {
        new UserService() {
            @Override
            public void create() {
                System.out.println("添加...");
            }
        }.create();
    }
}

abstract class BaseService {
    /**
     * 添加数据
     */
    abstract void create();
}

interface UserService {
    /**
     * 添加数据
     */
    void create();
}
