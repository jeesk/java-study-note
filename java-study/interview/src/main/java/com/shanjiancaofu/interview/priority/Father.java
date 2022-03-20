package com.shanjiancaofu.interview.priority;

public class Father {


	static {
		System.out.println("父类静态代码块(1)");
	}

	Father() {
		System.out.println("父类构造器(2)");
	}

	{
		System.out.println("父类代码块(3)");
	}

	public int test() {
		System.out.println("父类普通字段(4)");
		return 1;
	}

	public static int method() {
		System.out.println("父类静态字段(5)");
		return 1;
	}

	private static int j = method();

	private int i = test();


}
