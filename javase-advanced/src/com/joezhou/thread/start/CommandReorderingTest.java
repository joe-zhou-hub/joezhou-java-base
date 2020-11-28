package com.joezhou.thread.start;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CommandReorderingTest {

    private volatile int x = 0, y = 0, a = 0, b = 0;

    @SneakyThrows
    @Test
    public void orderReorder() {

        int count = 0;

        while (true) {

            count++;

            Thread threadA = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread threadB = new Thread(() -> {
                b = 1;
                y = a;
            });

            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();

            System.out.printf("第%d次：x=%d，y=%d\n", count, x, y);

            if (x == 0 && y == 0) {
                break;
            } else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }
    }

    @SneakyThrows
    @After
    public void after(){
        System.out.println(System.in.read());
    }
}