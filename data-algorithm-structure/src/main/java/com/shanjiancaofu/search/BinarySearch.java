package com.shanjiancaofu.search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 8, 2};
		System.out.println("索引 ：" + search(arr, 0, arr.length - 1, 3));
	}

	public static int search(int[] arr, int left, int right, int targetEle) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (targetEle < arr[mid]) {
			return search(arr, left, mid, targetEle);
		} else if (targetEle > arr[mid]) {
			return search(arr, mid + 1, right, targetEle);
		}
		return left;
	}
}
