package com.example;

import com.example.exports_.Stu;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        // 可以正常访问stu
        var stu = new Stu();
        Class<?> aClass = null;
        try {
            // 没有导出的只能使用反射  j
            aClass = Class.forName("com.example.open.Person");
            Object o = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        out.println("Hello world!");
    }
}