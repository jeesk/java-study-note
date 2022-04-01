package com.shanjiancaofu.juc.thread.chapter01;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo extends Thread {
    private Object left, right;
    private Random ranoom;
    private AtomicInteger i = new AtomicInteger();

    public Demo(Object left, Object right) {
        ranoom = new Random();
        this.left = left;
        this.right = right;

    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(ranoom.nextInt(1000));
                synchronized (left) {
                    synchronized (right) {
                        i.incrementAndGet();
                        System.out.println(i.get());
                        Thread.sleep(ranoom.nextInt(1000));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
