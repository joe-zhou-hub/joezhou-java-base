package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class InterfaceClassTest {
    @Test
    public void userServiceBySubClass() {
        UserService userService = new UserServiceImpl();
        System.out.println(UserService.NAME);
        System.out.println(UserService.GENDER);
        userService.methodA();
    }
}

interface UserService {
    String NAME = "赵四";
    String GENDER = "female";

    void methodA();
}

class UserServiceImpl implements UserService {
    @Override
    public void methodA() {
        System.out.println("实现了methodA...");
    }
}
