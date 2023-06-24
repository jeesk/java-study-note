package com.shanjiancaofu.java9;

public interface PrivateMethodInterface {
    // 允许接口拥有私有方法
    private void printInternal(String str) {
        System.out.println(str);
    }

    default void print(String str) {
        this.printInternal(str);
    }
}
