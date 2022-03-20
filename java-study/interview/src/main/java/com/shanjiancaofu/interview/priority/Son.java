package com.shanjiancaofu.interview.priority;

public class Son extends Father {


	static {
		System.out.println("子类静态代码块(6)");
	}

	Son() {
		System.out.println("子类构造器(7)");
	}

	{
		System.out.println("子类代码块(8)");
	}

	public int test() {
		System.out.println("子类普通字段(9)");
		return 1;
	}

	public static int method() {
		System.out.println("子类静态字段(10)");
		return 1;
	}

	private static int j = method();
	private int i = test();

	public static void main(String[] args) {

		// 首先是父类的所有静态字段和静态代码块，
		// 然后是子类静态字段，静态代码块
		// 父类代码块，字段，构造器
		// 子类代码块，字段，构造器
		// 还要考虑方法被重写（final private , 静态方法不会重写）
		Son son = new Son();
		System.out.println(son.test());
		System.out.println();
		Son son1 = new Son();
		// 请输出执行顺序
	}
}

