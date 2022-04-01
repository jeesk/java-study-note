package com.shanjiancaofu.juc.thread.chapter08;

public class ThreadCoreSizeTest {
    public static void main(String[] args) {

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
