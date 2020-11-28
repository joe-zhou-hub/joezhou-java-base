package com.joezhou.type;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class StringToolTest {

    @Test
    public void plusSignStitchingTimeConsuming() {
        // 获取时间戳：距离1970年1月1日 0点0时0分 一个毫秒数。
        long startTime = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < 100000; i++) {
            str = str + i;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime) + "毫秒");
    }

    @Test
    public void stringBuilderStitchingTimeConsuming() {
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime) + "毫秒");
    }

    @Test
    public void stringBuilderApi() {
    }


}
