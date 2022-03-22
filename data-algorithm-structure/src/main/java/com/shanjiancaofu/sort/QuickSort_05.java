package com.shanjiancaofu.sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort_05 {


	public static void main(String[] args) {
		int count = 20000000;
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = (int) (Math.random() * count); // 生成一个[0, 8000000) 数
		}
	}

	public static void quickSort(List<Integer> lsit) {
		long start = System.currentTimeMillis();
		int[] tmp = new int[lsit.size()];
		for (int i = 0; i < lsit.size(); i++) {
			tmp[i] = lsit.get(i);
		}
		quickSort(tmp, 0, lsit.size() - 1);
		System.out.printf("total %s numbers, quickSort cost %s ms \n", lsit.size(), (System.currentTimeMillis() - start));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int l = left; //左下标
		int r = right; //右下标
		//pivot 中轴值
		int pivot = arr[(left + right) / 2];
		int temp = 0; //临时变量，作为交换时使用
		//while循环的目的是让比pivot 值小放到左边
		//比pivot 值大放到右边
		while (l < r) {
			//在pivot的左边一直找,找到大于等于pivot值,才退出
			while (arr[l] < pivot) {
				l += 1;
			}
			//在pivot的右边一直找,找到小于等于pivot值,才退出
			while (arr[r] > pivot) {
				r -= 1;
			}
			//如果l >= r说明pivot 的左右两的值，已经按照左边全部是
			//小于等于pivot值，右边全部是大于等于pivot值
			if (l >= r) {
				break;
			}

			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			//如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
			if (arr[l] == pivot) {
				r -= 1;
			}
			//如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
			if (arr[r] == pivot) {
				l += 1;
			}

		}

		// 如果 l == r, 必须l++, r--, 否则为出现栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}

		//  右边的数都没有比左边小小
		if (left < r) {
			quickSort(arr, left, r);
		}
		//向右递归
		if (right > l) {
			quickSort(arr, l, right);
		}
	}

}
