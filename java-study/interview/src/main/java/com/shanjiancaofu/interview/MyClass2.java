package com.shanjiancaofu.interview;

public class MyClass2 {


	static {
		System.out.println("静态代码");
	}

	int n = 1;
	int m = method();

	int method() {
		System.out.println(n);
		return n;
	}


	public static void main(String[] args) {
		MyClass2 myClass2 = new MyClass2();
		System.out.println(myClass2.m);
		System.out.println(myClass2.method());
		// 0
		// 0
		// 1
		// 1
	}
}
