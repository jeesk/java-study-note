package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

public interface IUserSpecification {
    //候选者是否满足要求
    public boolean isSatisfiedBy(User user);
}
