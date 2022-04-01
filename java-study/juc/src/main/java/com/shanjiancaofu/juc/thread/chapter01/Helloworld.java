package com.shanjiancaofu.juc.thread.chapter01;

public class Helloworld {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(12312);
        }).start();

        Thread.yield();
        System.out.println(55555);
    }





}
