package com.shanjiancaofu.interview;

public class MyClass3 {


	int n = 1;


	int method() {
		System.out.println(n);
		return n;
	}

	int m = method();

	public static void main(String[] args) {
		MyClass2 myClass2 = new MyClass2();
		// 下面分别打印2次
		System.out.println(myClass2.m);
		System.out.println(myClass2.method());
		// 1
		// 1
		// 1
		// 1
	}
}
