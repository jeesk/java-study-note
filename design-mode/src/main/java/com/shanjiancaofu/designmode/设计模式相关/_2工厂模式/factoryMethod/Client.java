package com.shanjiancaofu.designmode.设计模式相关._2工厂模式.factoryMethod;


public class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();  // 每一个工厂负责一个具体的产品
        Car c2 = new BydFactory().createCar();
        Car car = new BenzFactory().createCar();
        c1.run();
        c2.run();
    }
}
