package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

public class UserByNameEqual extends CompositeSpecification {
    //基准姓名
    private String name;

    //构造函数传递基准姓名
    public UserByNameEqual(String _name) {
        this.name = _name;
    }

    //检验用户是否满足条件
    @Override
    public boolean isSatisfiedBy(User user) {
        return user.getName().equals(name);
    }


}
