package com.shanjiancaofu.designmode.设计模式相关.策略设计模式2;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();

        player.buy(5000D);
        //  通过传递不同的价格, 然后设置不同的策略对象, 调用不同的策略对象即可
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }
}
