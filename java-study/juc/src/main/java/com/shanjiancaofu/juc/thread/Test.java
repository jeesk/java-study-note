package com.shanjiancaofu.juc.thread;

public abstract class Test implements Cloneable {

    public static void main(String[] args) {

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }
}
