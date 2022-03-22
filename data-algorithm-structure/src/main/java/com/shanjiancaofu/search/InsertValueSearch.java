package com.shanjiancaofu.search;


public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3, 4, 5, 6, 7};
		System.out.println(insertValueSearch(arr, 0, arr.length - 1, 7));
	}


	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		// 自适应查找
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midValue = arr[mid];
		if (findVal > midValue) {
			return insertValueSearch(arr, left, mid, findVal);
		} else if (findVal < midValue) {
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else {
			return mid;
		}
	}

}
