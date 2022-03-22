package com.shanjiancaofu.effctiveJava.静态工厂方法;

public class Demo {
    public static void main(String[] args) {
        // 静态工厂方法主要就取缓存的东西


       Services.registerProvider("hello", () -> () -> 100);
       Service hello = Services.newInstance("hello");
        System.out.println(hello.print());
    }
}

// 静态工厂方法 Services 是一个工厂, 提供了注册的方法,
//   registerProvider(Provider p,String name)  指定Key注册
// 和生产的方法  Provider newInstance(String name)  获得指定的key
// Provider.newInstance() 返回的是Service对象
