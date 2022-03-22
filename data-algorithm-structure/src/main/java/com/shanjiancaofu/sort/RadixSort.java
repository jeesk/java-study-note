package com.shanjiancaofu.sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {6, 5, 4, 3, 2};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void radixSort(int[] arr) {
		// 寻找最大的值, 定义有多少个桶
		int maxLenth = 0;
		for (int i : arr) {
			maxLenth = Math.max(i, maxLenth);
		}
		maxLenth = (maxLenth + "").length();
		// 放入桶中排序
		int[][] bucket = new int[10][arr.length];
		int[] bucketEleCounts = new int[10];

		for (int i = 0, n = 1; i < maxLenth; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				int digitEle = arr[j] / n % 10;
				// 放入桶里面
				bucket[digitEle][bucketEleCounts[digitEle]] = arr[j];
				// 某个桶元素数量加1
				bucketEleCounts[digitEle]++;
			}
			// 按照桶的顺序,
			int tempIndex = 0;
			for (int k = 0; k < bucketEleCounts.length; k++) {
				if (bucketEleCounts[k] != 0) {
					for (int i2 = 0; i2 < bucketEleCounts[k]; i2++) {
						arr[tempIndex++] = bucket[k][i2];
					}
				}
				bucketEleCounts[k] = 0;
			}
		}

	}
}
