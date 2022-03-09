package com.shanjiancaofu.juc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchUtil {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 1999; i++) {
            objects.add(i);
        }
        int size = 2000;
        int pageCount = objects.size() % size == 0 ? objects.size() / size : objects.size() / size + 1;
        int startIndex = 0;
        for (int i = 1; i <= pageCount; i++) {
            List<Object> tmpObjects = null;
            if (i != pageCount) {
                tmpObjects = objects.subList(startIndex, startIndex + size);
                startIndex += size;
            } else {
                tmpObjects = objects.subList(startIndex, objects.size());
            }
            System.out.println(tmpObjects.size());
        }

    }


    private CountDownLatch start;
    private CountDownLatch end;
    private int pollSize = 10;

    public CountDownLatchUtil() {
        this(10);
    }

    public CountDownLatchUtil(int pollSize) {
        this.pollSize = pollSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(pollSize);
    }

    public void latch(MyFunctionalInterface functionalInterface) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(pollSize);
        for (int i = 0; i < pollSize; i++) {


            executorService.submit(() -> {
                try {
                    try {
                        start.await(); // 一直阻塞线程. 所有调用的都会阻塞, 然后, 执行CountDown 的时候, 会立刻执行.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    functionalInterface.run();
                } finally {
                    end.countDown();
                }
            });
        }


        start.countDown();
        end.await(); // 保证1000 个线程执行完成才关闭线程池子
        executorService.shutdown();

    }


    @FunctionalInterface
    public interface MyFunctionalInterface {
        void run();

    }

}
