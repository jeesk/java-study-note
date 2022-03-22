package com.shanjiancaofu.algorithm;

public class BinarySearchNorecur {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int i = binarySearch(arr, 8);
		System.out.println(i);
	}

	public static int binarySearch(int[] arr, int finaNumber) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int i = arr[mid];
			if (finaNumber < i) {
				right = mid - 1;
			} else if (finaNumber > i) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
