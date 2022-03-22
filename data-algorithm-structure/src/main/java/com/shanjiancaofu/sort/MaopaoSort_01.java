package com.shanjiancaofu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaopaoSort_01 {

	//  这冒泡排序
	public static void main(String[] args) {
		int numCount = 10;
		List<Integer> numbers = generateList(numCount);
		Collections.shuffle(numbers);
		bubbleSort(numbers);
		bubbleSortOpt1(numbers);
		long start = System.currentTimeMillis();
		Collections.sort(numbers);
		System.out.printf("total %s numbers, sort cost %s ms \n", numbers.size(), (System.currentTimeMillis() - start));
	}


	/**
	 * 冒泡排序, 每次将第n个数比较, 将第n个数后面的数, 如果较大或者较小就交换, 需要循环n*(n-1);
	 *
	 * @param lists
	 */
	public static void bubbleSort(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();
		int temp;
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
				count++;
			}
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, bubbleSort cost %s ms \n", nums.length, costTime);
	}

	public static void bubbleSortOpt1(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();
		int temp;
		boolean isChange = false;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					isChange = true;
				}
			}
			if (!isChange) {
				break;
			} else {
				// 发生了交换
				isChange = false;
			}
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, bubbleSortOpt1 cost %s ms \n", nums.length, costTime);
	}

	static List<Integer> generateList(int count) {
		List<Integer> numbers = new ArrayList<Integer>();
		{
			for (int i = 0; i < count; i++) {
				numbers.add(i);
			}
		}
		return numbers;
	}
}
