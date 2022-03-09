package com.shanjiancaofu.algorithm;

public class Hanoitower {
	public static void main(String[] args) {
		hannoiTower(3, 'A', 'B', 'C');
	}

	public static void hannoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("第1个盘从" + a + " -> " + c);
		} else {
			// a -> b ， 会用到c, 先把上面全面移动到b
			hannoiTower(num - 1, a, c, b);
			System.out.println("第" + num + "个盘从" + a + " -> " + c);
			hannoiTower(num - 1, b, a, c);
		}
	}

}
