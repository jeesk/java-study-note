package com.shanjiancaofu.jvmstudy.finallyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、finally中的代码总会被执行。
 * <p>
 * 2、当try、catch中有return时，也会执行finally。return的时候，要注意返回值的类型，是否受到finally中代码的影响。如果return 在代码最后会收到finally 影响。
 * <p>
 * 3、finally中有return时，会直接在finally中退出，导致try、catch中的return失效。
 * <p>
 * <p>
 * 简单的总结一下： 当try catch 的return 在finally 前面的时候， 基本类型的变量不会受到finally 影响， 如果在finally 后面的时候， 数据会受到finally 的操作影响
 */

public class FinallyQuestion {
	public static void main(String[] args) {
		FinallyQuestion fq = new FinallyQuestion();
		System.out.println(fq.testReturn1());
		fq.printlf("hello world");
	}


	public void printlf(String str){

	}

	private int testReturn1() {
		// 这里的finally 执行后会返回到try 的return 后面执行。
		int i = 1;
		try {
			i++;
			System.out.println("try:" + i);
			return i;
		} catch (Exception e) {
			i++;
			System.out.println("catch:" + i);
		} finally {
			i++;
			System.out.println("finally:" + i);
		}
		return i;
	}

	private List<Integer> testReturn2() {
		List<Integer> list = new ArrayList<>();
		try {
			list.add(1);
			System.out.println("try:" + list);
			return list;
		} catch (Exception e) {
			list.add(2);
			System.out.println("catch:" + list);
		} finally {
			list.add(3);
			System.out.println("finally:" + list);
		}
		return list;
	}

	private int testReturn3() {
		int i = 1;
		try {
			i++;
			System.out.println("try:" + i);
			int x = i / 0;
		} catch (Exception e) {
			i++;
			System.out.println("catch:" + i);
			return i;
		} finally {
			i++;
			System.out.println("finally:" + i);
		}
		return i;
	}

	private int testReturn4() {
		int i = 1;
		try {
			i++;
			System.out.println("try:" + i);
			return i;
		} catch (Exception e) {
			i++;
			System.out.println("catch:" + i);
			return i;
		} finally {
			i++;
			System.out.println("finally:" + i);
			return i;
		}
	}
}
