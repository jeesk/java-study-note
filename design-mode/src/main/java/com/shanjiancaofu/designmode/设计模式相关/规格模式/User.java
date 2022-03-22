package com.shanjiancaofu.designmode.设计模式相关.规格模式;

import lombok.Data;

@Data
public class User {
    //姓名
    private String name;
    //年龄
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //用户信息打印
    @Override
    public String toString() {
        return "用户名：" + name + "\t年龄：" + age;
    }
}
