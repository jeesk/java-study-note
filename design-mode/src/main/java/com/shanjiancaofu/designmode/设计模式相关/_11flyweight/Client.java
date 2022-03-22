package com.shanjiancaofu.designmode.设计模式相关._11flyweight;

public class Client {
	public static void main(String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");



		System.out.println(chess1);
		System.out.println(chess2);

		System.out.println("增加外部状态的处理===========");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
		 // 优点： 极大减少内存中对象的数量
		//		相同或者相似对象内存中只存一份， 节约资源。
		// 外部状态相对独立， 不影响内部状态
		// 为了节约内存，共享了内部状态。 分离除类外部状态。 读取外部状态， 使运行时间变长， 用时间换取了空间。


		//  享元模式, 就是资源池的一种形式.

	}
}
