package com.shanjiancaofu.designmode.设计模式相关.模板设计模式;

// 客户端类
public class Client {

    public static void main(String[] args) {

        Account account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号的利息数额为：" + account.calculateInterest());
    }

}
