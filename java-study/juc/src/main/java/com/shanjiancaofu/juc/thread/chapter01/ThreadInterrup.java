package com.shanjiancaofu.juc.thread.chapter01;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInterrup {

    @Test // T1 �ò�����, �ͱ�����  , ������Ӧ�ж�
    public void test3() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            } catch (Exception e) {
                System.out.println(e);
            }

        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }


     @Test // T1 �ò�����, �ͱ�����  , ������Ӧ�ж�
    public void test10() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);

        Thread t1 = new Thread(() -> {
            try {
                lock.tryLock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            } catch (Exception e) {
                System.out.println(e);
            }

        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }

    @Test
    public void test4() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly(); // ����Ӧ�ж�
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        Thread.sleep(1000000);
    }


    @Test
    public void test5() throws Exception {
        final Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        t1.interrupt();
        Thread.sleep(10000000);
    }
}
