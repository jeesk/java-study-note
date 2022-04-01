package com.shanjiancaofu.performanceopt;

public class Test {
	public static void main(String[] args) {
		Class<? extends Class> aClass = Deprecated.class.getClass();
		System.out.println(aClass);
	}
}
