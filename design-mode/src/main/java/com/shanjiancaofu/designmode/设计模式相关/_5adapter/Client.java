package com.shanjiancaofu.designmode.设计模式相关._5adapter;

/**
 * 客户端类
 * (相当于例子中的笔记本，只有USB接口)
 *
 * @author Administrator
 */
public class Client {

    public void test1(Target t) {
        t.handleReq();
    }

    public static void main(String[] args) {
        Client c = new Client(); //

        // 实际的类
        Adaptee a = new Adaptee();

        Target t = new Adapter(); // 使用继承(类的方式)的方式  。  使

        // 将实际的类， 放入适配器中。 使用组合()的方式， 调用真实的方法
        //Target t = new Adapter2(a);

        c.test1(t);

        //      将一个类的接口变换成客户
        // 端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作

        // 比如两个公司的用户 信息这一个例子。  只要继承需要适配的类， 实现要匹配的接口即可。




        //  如果适配的是接口有多个 ， 那么可以使用关联来适配，而不是接口。
        //
    }

}
