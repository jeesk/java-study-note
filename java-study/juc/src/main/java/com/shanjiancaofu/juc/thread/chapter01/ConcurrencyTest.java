package com.shanjiancaofu.juc.thread.chapter01;

/**
 * �����͵��߳�ִ�в���
 *
 * @author tengfei.fangtf
 * @version $Id: ConcurrencyTest.java, v 0.1 2014-7-18 ����10:03:31 tengfei.fangtf Exp $
 */
public class ConcurrencyTest {

    /**
     * ִ�д���
     */
    private static final long count = 100000000L;

    public static void main(String[] args) throws InterruptedException {
        //��������
        concurrency();
        //���̼߳���
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
            System.out.println(a);
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join(); // 直到线程执行完成后才, 结束
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
