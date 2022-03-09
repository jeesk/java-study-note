package com.shanjiancaofu.interview;

public class StringReference_01 {
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c"; // 不是同一引用
		String s4 = "a" + "b";

		// 是一样的
		System.out.println(s4.hashCode());
		System.out.println(s1.hashCode());
		// true true
		System.out.println(s4 == s1);
		System.out.println(s4.equals(s1));


		// 相等
		System.out.println(s3.hashCode());
		System.out.println(s2.hashCode());
		// false
		System.out.println(s3 == s2);
		// true
		System.out.println(s3.equals(s2));
	}
}
