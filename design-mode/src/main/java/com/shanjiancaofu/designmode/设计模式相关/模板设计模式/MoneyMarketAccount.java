package com.shanjiancaofu.designmode.设计模式相关.模板设计模式;

// 　　具体模板角色类1
public class MoneyMarketAccount extends Account {

    @Override
    protected String doCalculateAccountType() {

        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {

        return 0.045;
    }

}
