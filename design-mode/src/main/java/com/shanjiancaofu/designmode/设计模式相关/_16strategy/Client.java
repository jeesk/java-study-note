package com.shanjiancaofu.designmode.设计模式相关._16strategy;

public class Client {
    public static void main(String[] args) {

        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1);
        ctx.pringPrice(998);
        // 根据不同的情况， 使用不同的类处理事件。 代替if else


        //   枚举的抽象方法 ， 每一个枚举都必须实现抽象方法。 这也说明 ， 抽象方法 是一个很好的策略模式

    }
}
