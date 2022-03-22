package com.shanjiancaofu.sort;

import java.util.Arrays;

// 归并排序
// 1. 将数组分为2个数据有序数组（递归）
// 2. 将2个数组比较， 将较小的数据放在前面
// 3. 将某个数组中剩余的数据放在末尾
public class MergeSort_06 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 10); // 生成一个[0, 10) 数
		}
		long start = System.currentTimeMillis();
		int[] resultArr = mergeSortNew(arr, 0, arr.length - 1);
		System.out.println("耗时：" + (System.currentTimeMillis() - start));
		int[] tempArr = new int[arr.length];
		start = System.currentTimeMillis();
		mergeSort(arr, 0, arr.length - 1, tempArr);
		System.out.println("耗时：" + (System.currentTimeMillis() - start));
	}

	// 归并排序
	// 1. 将数组分为2个数据有序数组（递归）
	// 2. 将2个数组比较， 将较小的数据放在前面
	// 3. 将某个数组中剩余的数据放在末尾

	public static int[] mergeSortNew(int[] arr, int left, int right) {
		if (left == right) {
			return new int[]{arr[left]};
		}
		int mid = (left + right) / 2;

		// 1. 将数组分为2个数据有序数组（递归）
		int[] leftArr = mergeSortNew(arr, left, mid);
		int[] rightArr = mergeSortNew(arr, mid + 1, right);
		int[] newArr = new int[leftArr.length + rightArr.length];
		int newArrIndex = 0, lIndex = 0, rIndex = 0;
		// 2. 将2个数组比较， 将较小的数据放在前面
		while (lIndex < leftArr.length && rIndex < rightArr.length) {
			newArr[newArrIndex++] = leftArr[lIndex] < rightArr[rIndex] ? leftArr[lIndex++] : rightArr[rIndex++];
		}
		while (lIndex < leftArr.length) {
			newArr[newArrIndex++] = leftArr[lIndex++];
		}
		while (rIndex < rightArr.length) {
			newArr[newArrIndex++] = rightArr[rIndex++];
		}
		return newArr;
	}

	public static int[] mergeSort(int[] nums, int left, int right) {
		if (left == right) return new int[]{nums[left]};
		//int mid = left + (right - left) / 2;
		int mid = (right + left) / 2;
		int[] leftArr = mergeSort(nums, left, mid); //左有序数组
		int[] rightArr = mergeSort(nums, mid + 1, right); //右有序数组
		int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

		int m = 0, i = 0, j = 0;
		// 将最小的移动到左边
		while (i < leftArr.length && j < rightArr.length) {
			newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
		}
		// 如果还有剩余的数， 那么将数据放到末尾
		while (i < leftArr.length) {
			newNum[m++] = leftArr[i++];
		}
		while (j < rightArr.length) {
			newNum[m++] = rightArr[j++];
		}
		return newNum;
	}

	//分+合方法
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2; //中间索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid + 1, right, temp);
			//合并
			merge(arr, left, mid, right, temp);

		}
	}

	//合并的方法

	/**
	 * @param arr   排序的原始数组
	 * @param left  左边有序序列的初始索引
	 * @param mid   中间索引
	 * @param right 右边索引
	 * @param temp  做中转的数组
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

		int i = left; // 初始化i, 左边有序序列的初始索引
		int j = mid + 1; //初始化j, 右边有序序列的初始索引
		int t = 0; // 指向temp数组的当前索引

		//(一)
		//先把左右两边(有序)的数据按照规则填充到temp数组
		//直到左右两边的有序序列，有一边处理完毕为止
		while (i <= mid && j <= right) {//继续
			//如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
			//即将左边的当前元素，填充到 temp数组
			//然后 t++, i++
			temp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}

		//(二)
		//把有剩余数据的一边的数据依次全部填充到temp
		while (i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
			temp[t++] = arr[i++];
		}

		while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
			temp[t++] = arr[j++];
		}


		//(三)
		//将temp数组的元素拷贝到arr
		//注意，并不是每次都拷贝所有
		t = 0;
		//第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
		//最后一次 tempLeft = 0  right = 7
		while (left <= right) {
			arr[left++] = temp[t++];
		}

	}

}
