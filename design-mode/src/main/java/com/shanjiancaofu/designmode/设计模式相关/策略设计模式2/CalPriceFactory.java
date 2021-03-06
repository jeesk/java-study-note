package com.shanjiancaofu.designmode.设计模式相关.策略设计模式2;

public class CalPriceFactory {
    private CalPriceFactory() {
    }

    //根据客户的总金额产生相应的策略
    public static CalPrice createCalPrice(Player customer) {



        if (customer.getTotalAmount() > 30000) {//3000则改为金牌会员计算方式
            return new GoldVip();
        } else if (customer.getTotalAmount() > 20000) {//类似
            return new SuperVip();
        } else if (customer.getTotalAmount() > 10000) {//类似
            return new Vip();
        } else {
            return new Orgnic();
        }
    }
}
