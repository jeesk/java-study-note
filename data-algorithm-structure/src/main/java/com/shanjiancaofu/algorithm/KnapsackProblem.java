package com.shanjiancaofu.algorithm;

import java.util.Arrays;

public class KnapsackProblem {
	public static void main(String[] args) {
		int[] weightArr = {1, 4, 3};
		int[] goodsValArr = {1500, 3000, 2000};

		// m 表示背包最大5磅
		int m = 5;
		int n = goodsValArr.length;
		// v[i][j] 表示前i个物品中能够装入容量为j的背包中的最大价值
		//  第一个数组表示第几个商品商品， 二维数组表示表示0 ~m的背包可以放的重量
		int[][] v = new int[n + 1][m + 1];
		int[][] path = new int[n + 1][m + 1];
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		Arrays.fill(v[0], 0);

		// 不处理第一行
		for (int goodsIndex = 1; goodsIndex < v.length; goodsIndex++) {

			for (int packWeight = 1; packWeight < v[0].length; packWeight++) {
				int thingWeight = weightArr[goodsIndex - 1];
				// 当装备加入新增的商品容量大于背包的容量，直接使用上一个单元格的装入策略
				// v[goodsIndex - 1][packWeight]表示上一个单元格
				if (goodsIndex == 3 && packWeight == 5) {
					int rrr = 33;
				}
				if (thingWeight > packWeight) {
					v[goodsIndex][packWeight] = v[goodsIndex - 1][packWeight];
				} else {
					// val[i - 1]  当前物品重量加上
					//  packWeight - thingWeight 剩余重量在上一个商品的最大价值
					int value = v[goodsIndex - 1][packWeight - thingWeight];

					// 为了记录商品存放到背包人情况, 我应该使用if else
					if (v[goodsIndex - 1][packWeight] < goodsValArr[goodsIndex - 1] + value) {
						v[goodsIndex][packWeight] = goodsValArr[goodsIndex - 1] + value;
						// 记录最优值
						path[goodsIndex][packWeight] = 1;
					} else {
						v[goodsIndex][packWeight] = v[goodsIndex - 1][packWeight];
					}
				}
			}
		}

		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

		int i = path.length - 1;
		int j = path[0].length - 1;
		// 从最优解
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("第%s个商品放入背包\n", i);
				j -= weightArr[i - 1];
			}
			i--;
		}
	}
}
