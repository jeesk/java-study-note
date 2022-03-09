package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式;

public class Client {
    public static void main(String[] args) {
        //从工厂中获得一个对象
        SignInfo signInfo = SignInfoFactory.getSignInfo(1+"");
        //进行其他业务处理
    }
}
