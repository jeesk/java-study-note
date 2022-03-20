package com.shanjiancaofu.jvmstudy.override;

/**
 * 静态分派
 * 1.当参数是一个静态类的时候， 优先匹配静态类
 * 2. 当参数是一个普通类的时候匹配普通类
 */
public class StaticDispatch {
	static abstract class Human{

	}
	static class Man extends Human{

	}
	static class Woman extends Human{

	}

	public void sayHello(Man guy) {
		System.out.println("hello , gentle!");
	}
	public void sayHello(Woman guy) {
		System.out.println("hello , ladly!");
	}

	public void sayHello(Human guy) {
		System.out.println("hello , guy!");
	}
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sr = new StaticDispatch();
		sr.sayHello(man);
		sr.sayHello(woman);

		Man man1 = new Man();
		Woman woman1 = new Woman();
		sr.sayHello(man1);
		sr.sayHello(woman1);
	}
}
