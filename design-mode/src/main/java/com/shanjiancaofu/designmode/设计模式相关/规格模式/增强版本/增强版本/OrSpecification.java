package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

public class OrSpecification extends CompositeSpecification {
    //左右两个规格书
    private IUserSpecification left;
    private IUserSpecification right;

    public OrSpecification(IUserSpecification _left, IUserSpecification _right) {
        this.left = _left;
        this.right = _right;
    }

    //or运算
    @Override
    public boolean isSatisfiedBy(User user) {
        return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
    }
}
