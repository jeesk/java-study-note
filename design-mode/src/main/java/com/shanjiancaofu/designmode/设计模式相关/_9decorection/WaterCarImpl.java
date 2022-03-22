package com.shanjiancaofu.designmode.设计模式相关._9decorection;

public class WaterCarImpl implements ICar {
    private ICar car;

    public WaterCarImpl(ICar car) {
        this.car = car;
    }

    @Override
    public void fly() {
        car.fly();
        waterFly();
    }

    public void waterFly() {
        System.out.println("水上飞！");

    }

}
