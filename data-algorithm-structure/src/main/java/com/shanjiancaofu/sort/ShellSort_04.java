package com.shanjiancaofu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ShellSort_04 {


	public static void main(String[] args) {
		int numCount = 10;
		List<Integer> numbers = generateList(numCount);
		Collections.shuffle(numbers);
		shellSort(numbers);
		shellSort1(numbers);

		long start = System.currentTimeMillis();
		Collections.sort(numbers);
		System.out.printf("total %s numbers, sort cost %s ms \n", numbers.size(), (System.currentTimeMillis() - start));
	}


	public static void shellSort(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();

		// shell 排序，
		// 假如数组有m个元素，得到一个步长  gap = m,gap/=2 然后每次遍历gap~m次，
		int temp = 0;

		for (int gap = nums.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < nums.length; i++) {

				for (int j = i - gap; j >= 0; j -= gap) {
					// System.out.println(String.format("%s 和 %s 比较", j, gap));
					if (nums[j] > nums[j + gap]) {
						temp = nums[j];
						nums[j] = nums[j + gap];
						nums[j + gap] = temp;
					}
				}
				// System.out.println(String.format("gap:%s %s", gap, Arrays.toString(nums)));
			}
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, shellSort cost %s ms \n  ", nums.length, costTime);
	}

	public static void shellSort1(List<Integer> lists) {
		Integer[] nums = lists.toArray(new Integer[0]);
		long start = System.currentTimeMillis();

		// shell 排序，
		// 假如数组有m个元素，得到一个步长  gap = m,gap/=2 然后每次遍历gap~m次，

		for (int gap = nums.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < nums.length; i++) {

				int j = i;
				int temp = nums[j];

				if (nums[j] < nums[j - gap]) {
					while ((j - gap) >= 0 && temp < nums[j - gap]) {
						nums[j] = nums[j - gap];
						j =   j -  gap;
					}
					// 当退出while 后， 就给temp 找到插入的位置
					nums[j] = temp;
				}

			}
		}
		long costTime = System.currentTimeMillis() - start;
		System.out.printf("total %s numbers, shellSort2 cost %s ms \n  ", nums.length, costTime);
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
