package com.shanjiancaofu.jvmstudy.init;

public class Test {
	public static void main(String[] args) {
		createArrayObject();

	}

	/**
	 * 通过子类引用父类的静态字段, 不会初始化子类的
	 */
	public static void test1() {
		System.out.println(SubClass.value);
	}

	/**
	 * 通过数组来引用类， 不会触发此类的初始化
	 */
	public static void createArrayObject() {
		SuperClass[] superClass = new SuperClass[1];
	}

	/**
	 * 常量在编译会存入调用类的常量池里面， 本质上并没有直接引用到定义常量的类
	 */
	public static void constReference() {
		System.out.println(ConstClass.HELLO_WORLD);
	}
}
