package com.shanjiancaofu.graph;

/**
 * 递归
 */
public class MyMiGong_Recursion {

	public static void main(String[] args) {
		int[][] array = {
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 1},
			{1, 0, 1, 0, 1, 1, 0, 1},
			{1, 0, 1, 1, 0, 0, 1, 1},
			{1, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 0, 0, 0, 1, 0, 1},
			{1, 1, 1, 1, 1, 0, 0, 1},
			{1, 1, 0, 0, 0, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1}
		};
		MyMiGong_Recursion myMiGong1 = new MyMiGong_Recursion();
		myMiGong1.nextStep(array, 1, 1);

	}

	public boolean nextStep(int[][] array, int i, int j) {

		if (array[7][6] == 2) {
			System.out.println("已经找到出口");
			for (int index = 0; index < 9; index++) {
				for (int twoIndex = 0; twoIndex < 8; twoIndex++) {
					System.out.print(array[index][twoIndex] + " ");
				}
				System.out.println();
			}
			return true;
		} else {
			if (array[i][j] == 0) {
				array[i][j] = 2;
				// 上下左右
				if (nextStep(array, i + 1, j)) {//向下走
					return true;
				} else if (nextStep(array, i, j + 1)) { //向右走
					return true;
				} else if (nextStep(array, i - 1, j)) { //向上
					return true;
				} else if (nextStep(array, i, j - 1)) { // 向左走
					return true;
				} else {
					//说明该点是走不通，是死路
					array[i][j] = 3;
					return false;
				}
			} else {
				// 该路已经走过
				return false;
			}
		}
	}
}
