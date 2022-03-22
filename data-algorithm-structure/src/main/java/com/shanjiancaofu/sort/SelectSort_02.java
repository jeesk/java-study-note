package com.shanjiancaofu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SelectSort_02 {


	public static void main(String[] args) {
		int numCount = 20;
		List<Integer> numbers = generateList(numCount);


		Collections.shuffle(numbers);
		selectSort1(numbers);
		selectSort(numbers);

		long start = System.currentTimeMillis();
		Collections.sort(numbers);
		System.out.printf("total %s numbers, sort cost %s ms \n", numbers.size(), (System.currentTimeMillis() - start));
	}


	/**
	 * 选择排序的原理是将数组看做一个有序数组和无序数组， 最开始的时候有序数组只有一个元素， 无序数组有（n-1）个元素，
	 * 每次从无序数组里面拿一个数和有序数组做比较，如果较小或者较大， 就将该比较的数据后移， 直到相等，然后将这个数插入到这个索这个索引中去
	 *
	 * @param lists
	 */
	public static void selectSort(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();

		// 插入排序的原理， 将n个待排序的元素看成有序表，和无序表，  最开始的时候有序表只有一个元素， 无无序表有(n-1）个元素，
		// 每次取一个元素插入到有序表合适的位置即可
		for (int i = 1; i < nums.length; i++) {
			int insertIndex = i - 1;
			int insertNum = nums[i];

			// 将数据插入到较小的一个位置
			while (insertIndex >= 0 && insertNum < nums[insertIndex]) {
				// 将数据
				nums[insertIndex + 1] = nums[insertIndex];
				insertIndex--;         //元素后移
			}
			nums[insertIndex + 1] = insertNum;      //插入到正确位置
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, selectSort cost %s ms \n ", nums.length, costTime);
	}

	public static void selectSort1(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();

		for (int i = 1; i < nums.length; i++) {
			int tempIndex = i - 1;
			int currentNum = nums[i];
			boolean isMove = false;
			while (tempIndex >= 0 && currentNum < nums[tempIndex]) {
				nums[tempIndex + 1] = nums[tempIndex];
				tempIndex--;
				isMove = true;
			}

			if (isMove) {
				// 最后将currentNum 插入到tempIndex
				nums[tempIndex + 1] = currentNum;
			}
		}

		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, selectSort1 cost %s ms \n ", nums.length, costTime);
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
