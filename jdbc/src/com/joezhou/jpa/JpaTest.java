package com.joezhou.jpa;

import com.joezhou.jpa.pojo.User;
import com.joezhou.jpa.tool.CreateTableTool;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class JpaTest {
    @Test
    public void createTable() {
        new CreateTableTool(User.class).build();
    }
}