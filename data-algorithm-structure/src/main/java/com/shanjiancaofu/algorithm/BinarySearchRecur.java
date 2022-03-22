package com.shanjiancaofu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchRecur {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int i = binarySearch(arr, 0, arr.length - 1, 7);
		System.out.println(i);
	}

	public static int binarySearch(int[] arr, int left, int right, int finaNumber) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midValue = arr[mid];
		if (arr[mid] < finaNumber) {
			return binarySearch(arr, mid + 1, right, finaNumber);
		}
		if (midValue > finaNumber) {
			return binarySearch(arr, left, mid - 1, finaNumber);
		}
		return mid;
	}


}
