package com.shanjiancaofu.interview;

public class Exam5 {
	static int s;
	int i;
	int j;

	{
		int i = 1;
		i++;
		j++;
		s++;
	}

	public void test(int j) {
		j++;
		i++;
		s++;
	}

	public static void main(String[] args) {
		Exam5 obj1 = new Exam5();
		Exam5 obj2 = new Exam5();
		obj1.test(10);
		obj1.test(10);
		obj2.test(30);
		System.out.println(String.format("obj1.i %s obj1.j %s obj1.s %s", obj1.i, obj1.j, obj1.s));
		System.out.println(String.format("obj2.i %s obj2.j %s obj2.s %s", obj2.i, obj2.j, obj2.s));
		// 2,1,5   1,1,5
	}
}
