package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

import java.util.ArrayList;

public interface IUserProvider {
    //根据条件查找用户
    public ArrayList<User> findUser(boolean condition);
}
