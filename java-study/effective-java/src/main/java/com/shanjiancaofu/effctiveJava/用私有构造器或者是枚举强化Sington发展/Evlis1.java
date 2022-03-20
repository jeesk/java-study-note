package com.shanjiancaofu.effctiveJava.用私有构造器或者是枚举强化Sington发展;

public enum Evlis1 {
    INSTANCE(1);

    private int a;

    Evlis1(int i) {
        this.a = i;
    }
}
