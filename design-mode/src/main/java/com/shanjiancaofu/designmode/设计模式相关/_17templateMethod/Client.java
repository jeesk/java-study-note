package com.shanjiancaofu.designmode.设计模式相关._17templateMethod;

public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        //采用匿名内部类
        BankTemplateMethod btm2 = new BankTemplateMethod() {

            @Override
            public void transact() {
                System.out.println("我要存钱！");
            }
        };
        btm2.process();

        BankTemplateMethod btm3 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要理财！我这里有2000万韩币");
            }
        };

        btm3.process();


        //  模板方法模式： 比如说统计时间。 父类有3个方法， 2个时间的开始和结束  ， 具体的行为是由子类来实现的。 由父类定义了一个模板，子类来实现具体的操作即可.
      // 比如在junit 中的方法， 写好了方法， 调用骨架即可。


    }
}


class DrawMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要取款！！！");
    }

}
