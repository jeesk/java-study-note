package com.shanjiancaofu.jvmstudy;

/**
 * 字符串的 == 是比较内存地址
 */
public class StringInternMethodTest {
	public static void main(String[] args) {
		String hello_world = new String("hello world");
		String intern = hello_world.intern();
		System.out.println(hello_world.equals(intern));
		String s = new StringBuilder("ja").append("ck").toString();

		System.out.println(s.intern() == s);

		String string = new String("1");
		String string2 = "1";
		String string3 = "1";
		System.out.println(string == string2);
		System.out.println(string2 == string3);

		String str3 = "2";
		String str4 = "2";
		String str5 = new String("2");
		String str6 = str5.intern();

		System.out.println(str3 == str4);
		System.out.println(str3 == str5);
		System.out.println(str3 == str6);
		System.out.println(str6 == str5);


	}
}
