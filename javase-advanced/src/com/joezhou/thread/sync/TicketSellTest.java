package com.joezhou.thread.sync;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class TicketSellTest {

    private static class Ticket implements Runnable {

        private int ticketNo;

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(1L);
                sellTicket();
            }
        }

        private void sellTicket() {
            int maxNo = 100;
            if (ticketNo < maxNo) {
                ticketNo++;
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + "卖票: " + ticketNo);
            }
        }
    }

    @Test
    public void sellTicket() {
        Ticket ticket = new Ticket();
        new Thread(ticket, "thread-A").start();
        new Thread(ticket, "thread-B").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}


