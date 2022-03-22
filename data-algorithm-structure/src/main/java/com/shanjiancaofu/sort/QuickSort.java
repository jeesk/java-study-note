package com.shanjiancaofu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//排序：		[-9, 78, 0, 23, -567, 70, -1, -900, 4561]
// -900 比 -567 小， -9 比-567 大， 将两个数交换
//	交换排序：[-900, 78, 0, 23, -567, 70, -1, -9, 4561]
//   78 比-567 大将。 -567 交换
//	交换排序：[-900, -567, 0, 23, 78, 70, -1, -9, 4561]
//  -9 比比78 大， 交换
//	交换排序：[-900, -567, 0, 23, -9, 70, -1, 78, 4561]
//
//	交换排序：[-900, -567, 0, 23, -9, -1, 70, 78, 4561]
//	交换排序：[-900, -567, 0, -1, -9, 23, 70, 78, 4561]
//	交换排序：[-900, -567, -9, -1, 0, 23, 70, 78, 4561]
// 快速排序的思路 不断将左边或者右边的数和中轴做比较， 然后交换, 每次交换一轮后 保证了， 左边的数小于中轴， 右边的数大于中轴。
// 但是， 左边的数还没有排序完成,  右边的数也是乱序， 那么继续分拆开
//
public class QuickSort {

	public static void main(String[] args) {
		//int[] arr = {15, 14, -6, 12, 13, 11, 10, 6, 0, 5, 3, 4, 2, 1};
		int[] arr = {15, 14, 12, 13, 11, 10, 6, 5, 3, 4, 2, 1};

		//测试快排的执行速度
		// 创建要给80000个的随机的数组
/*		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}*/

		//int[] arr = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
		int len = arr.length - 1;
		//int[] myArr = qsort(arr, 0, len);
		System.out.println("初始数组--：" + Arrays.toString(arr));
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		quickSort(arr, 0, arr.length - 1);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		//System.out.println("arr=" + Arrays.toString(arr));


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
				l++;
			}
			//在pivot的右边一直找,找到小于等于pivot值,才退出
			while (arr[r] > pivot) {
				r--;
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
			// System.out.println("交换排序：" + Arrays.toString(arr));
			System.out.println("交换排序--：" + Arrays.toString(arr));
		}
		System.out.println("-------------------------");
		//System.out.println("交换排序" + Arrays.toString(arr));
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

	public static int[] qsort(int arr[], int start, int end) {
		int pivot = arr[start];
		int i = start;
		int j = end;
		while (i < j) {
			while ((i < j) && (arr[j] > pivot)) {
				j--;
			}
			while ((i < j) && (arr[i] < pivot)) {
				i++;
			}
			if ((arr[i] == arr[j]) && (i < j)) {
				i++;
			} else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		if (i - 1 > start) arr = qsort(arr, start, i - 1);
		if (j + 1 < end) arr = qsort(arr, j + 1, end);
		return (arr);
	}


}
