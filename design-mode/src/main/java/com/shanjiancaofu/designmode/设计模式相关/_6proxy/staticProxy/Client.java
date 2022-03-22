package com.shanjiancaofu.designmode.设计模式相关._6proxy.staticProxy;

public class Client {
	public static void main(String[] args) {
		Star real = new RealStar();
		Star proxy = new ProxyStar(real);

		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();

		proxy.collectMoney();

	}
}
