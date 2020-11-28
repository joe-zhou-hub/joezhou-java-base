package com.joezhou.jpa;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MyJpaTest {

    @Test
    public void jpa() {
        new CreateTableTool(User.class).build();
    }
}