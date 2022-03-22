package com.shanjiancaofu.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestSort {
	public static void main(String[] args) {
		List<Integer> numbers = generateList(5000000);
		Collections.shuffle(numbers);
		MaopaoSort_01.bubbleSort(numbers);
		MaopaoSort_01.bubbleSortOpt1(numbers);
		SelectSort_02.selectSort(numbers);
		SelectSort_02.selectSort1(numbers);
		InsertSort_03.insertSort(numbers);
		ShellSort_04.shellSort(numbers);
		QuickSort_05.quickSort(numbers);
		long start = System.currentTimeMillis();
		Collections.sort(numbers);
		System.out.println("耗时:" + (System.currentTimeMillis() - start));
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
