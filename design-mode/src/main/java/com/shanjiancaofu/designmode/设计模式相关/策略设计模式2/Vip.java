package com.shanjiancaofu.designmode.设计模式相关.策略设计模式2;

public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.9;
    }
}
