package com.shanjiancaofu.designmode.设计模式相关._19state;


public class Client {
    public static void main(String[] args) {
        HomeContext ctx = new HomeContext();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());



        // 当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。
    }
}
