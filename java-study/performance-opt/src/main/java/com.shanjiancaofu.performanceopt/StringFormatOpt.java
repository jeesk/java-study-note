package com.shanjiancaofu.performanceopt;

public class StringFormatOpt {

	/**
	 * 结论拼接字符串的性能大于String.format
	 * @param args
	 */
	public static void main(String[] args) {
		long count = 100000;
		long start = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
			format("ad", "1234", "124");
		}
		System.out.println("format cost time "+ (System.currentTimeMillis()-start) +"ms");
		start = System.currentTimeMillis();
		for (long i = 0; i < count; i++) {
			wrap("ad", "1234", "124");
		}
		System.out.println("wrap cost time "+ (System.currentTimeMillis()-start) +"ms");
	}

	public static String format(String s1,String s2, String s3){
		return String.format("hello %s world %s 你好 %s", s1, s2, s3);
	}

	public static String wrap(String s1,String s2, String s3){
		return "hello " + s1 + " world" + s2 + " 你好 " + s3;
	}
}
