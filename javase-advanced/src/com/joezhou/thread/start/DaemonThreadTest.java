package com.joezhou.thread.start;

/**
 * @author JoeZhou
 */
public class DaemonThreadTest {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("daemon-thread...");
            }
        });

        // must before start()
        daemonThread.setDaemon(true);
        daemonThread.start();

        for (int i = 0, j = 30; i < j; i++) {
            System.out.println(i);
        }
    }
}