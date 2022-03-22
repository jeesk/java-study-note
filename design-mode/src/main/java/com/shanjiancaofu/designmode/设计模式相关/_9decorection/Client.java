package com.shanjiancaofu.designmode.设计模式相关._9decorection;

public class Client {
    public static void main(String[] args) {
        ICar waterCar = new WaterCarImpl(new ICarImpl());
        SkyCarImpl skyCar = new SkyCarImpl(waterCar);
        skyCar.fly();

        //  装饰者模式和桥接模式的区别在于， 装饰者模式是在于增强功能。可以动态的删除或者是增加新的功能。  缺点容易出错， 并且， 错误难以调试。
        // 大量小对象占据内存，容易出错。

        // 但是桥接模式为了解决 子类爆炸的问题， 和责任单一原则。 使用桥接模式是组合， 并且桥接模式是解决组合的问题，
        //  将抽象解欧, 抽象和抽象做桥接, 解决继承和子类爆炸的问题如何改变问题




    }


}
