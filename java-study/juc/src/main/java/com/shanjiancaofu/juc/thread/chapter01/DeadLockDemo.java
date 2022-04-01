package com.shanjiancaofu.juc.thread.chapter01;

/**
 * ????????
 * @author tengfei.fangtf
 * @version $Id: DeadLockDemo.java, v 0.1 2015-7-18 ????10:08:28 tengfei.fangtf Exp $
 */
public class DeadLockDemo {

    /** A?? */
    private static final String A = "A";
    /** B?? */
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private static void run() {
        synchronized (A) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B) {
                System.out.println("1");
            }
        }
    }

    private static void run2() {
        synchronized (B) {
            synchronized (A) {
                System.out.println("2");
            }
        }
    }

    private void deadLock() {


        Thread t1 = new Thread(DeadLockDemo::run);

        Thread t2 = new Thread(DeadLockDemo::run2);
        t1.start();
        t2.start();
    }

}
