package com.shanjiancaofu.designmode.设计模式相关._9decorection;

public class SkyCarImpl implements ICar {
    private ICar car;

    public SkyCarImpl(ICar cat) {
        this.car = cat;
    }

    @Override
    public void fly() {
        car.fly();
        skyFly();
    }

    public void skyFly() {
        System.out.println("天上fei");
    }
}
