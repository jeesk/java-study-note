package com.shanjiancaofu.designmode.设计模式相关._6proxy;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodProxy {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        String invoke = (String) lookup.findVirtual(String.class, "replace", MethodType.methodType(String.class, char.class, char.class)).invoke("abc", 'a', '2');
        System.out.println(invoke);


    }

    public void print() {
        System.out.println("12312");
    }


}
