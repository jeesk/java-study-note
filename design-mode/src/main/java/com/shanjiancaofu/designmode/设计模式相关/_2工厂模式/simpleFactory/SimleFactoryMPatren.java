package com.shanjiancaofu.designmode.设计模式相关._2工厂模式.simpleFactory;

public class SimleFactoryMPatren {

    public static Car factoryOf(String name) {
        if (name.equals("hongqi")) {
            return new Hongqi();
        } else if (name.equals("audi")) {
            return new Audi();
        }
        return null;
    }
}
