package com.shanjiancaofu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InsertSort_03 {


	public static void main(String[] args) {
		int numCount = 80000;
		List<Integer> numbers = generateList(numCount);


		Collections.shuffle(numbers);
		insertSort(numbers);

		long start = System.currentTimeMillis();
		Collections.sort(numbers);
		System.out.printf("total %s numbers, sort cost %s ms \n", numbers.size(), (System.currentTimeMillis() - start));
	}


	/**
	 * 插入排序， 将第n个数和和n后面的元素做比较，获取到最大或者最小的元素的索引和元素， 每一次循环完成后交换数据， 这个是冒泡排序的升级版本
	 * @param lists
	 */
	public static void insertSort(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			int minNum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (minNum < nums[j]) {
					minNum = nums[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 当前的数替换为上次最小的数
				nums[minIndex] = nums[i];
				nums[i] = minNum;
			}
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, insertSort cost %s ms \n ", nums.length, costTime);
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
