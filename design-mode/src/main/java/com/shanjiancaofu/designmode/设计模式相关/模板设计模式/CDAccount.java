package com.shanjiancaofu.designmode.设计模式相关.模板设计模式;

// 　　具体模板角色类2
public class CDAccount extends Account {

    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }

}
