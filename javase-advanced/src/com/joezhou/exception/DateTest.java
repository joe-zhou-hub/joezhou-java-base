package com.joezhou.exception;

import org.junit.Test;

import java.util.Date;

/**
 * @author JoeZhou
 */
public class DateTest {
    @Test
    public void build(){
        Date date = new Date();
        System.out.println(date);

        date = new Date(1000L);
        System.out.println(date);

        date.setTime(5000L);
        System.out.println(date.getTime());
    }
}
