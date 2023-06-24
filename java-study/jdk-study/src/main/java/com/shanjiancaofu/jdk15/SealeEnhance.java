package com.shanjiancaofu.jdk15;

//  密封类的使用, 限制只有某些类才可以 extend

// sealed 密封类关键字， permits 允许extend 的类
sealed class Animal permits Cat, Dog { }

final class Cat extends Animal {
}

final class Dog extends Animal {
}

public class SealeEnhance {
    public static void main(String[] args) {
//        使用密封类可以设置允许extend 的类，方便与管理
    }
}
