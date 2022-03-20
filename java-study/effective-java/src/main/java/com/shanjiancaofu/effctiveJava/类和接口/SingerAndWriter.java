package com.shanjiancaofu.effctiveJava.类和接口;

public interface SingerAndWriter extends Singer, Writer {
    @Override

    void write();

    @Override
    void sing();
}
