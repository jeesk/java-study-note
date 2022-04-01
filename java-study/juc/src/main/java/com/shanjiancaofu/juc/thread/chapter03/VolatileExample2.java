package com.shanjiancaofu.juc.thread.chapter03;

public class VolatileExample2 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileExample2 test = new VolatileExample2();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
        {
            Thread.yield();
        }
        System.out.println(test.inc);
    }
}
