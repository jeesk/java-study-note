package com.shanjiancaofu.designmode.设计模式相关._15command;

public class Client {
	public static void main(String[] args) {
		Command c = new ConcreteCommand(new Receiver());



		Invoke i = new Invoke(c);
		i.call();

		// 命令者模式， 调用一个方法的时候不用，自己去调用， 而是通过，中介去调用

//		new Receiver().action();

	}
}
