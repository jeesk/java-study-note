package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

public class UserByAgeThan extends CompositeSpecification {
    //基准年龄
    private int age;

    //构造函数传递基准年龄
    public UserByAgeThan(int _age) {
        this.age = _age;
    }


    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getAge() > age;
    }


}
