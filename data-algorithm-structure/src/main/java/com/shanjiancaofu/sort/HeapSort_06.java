package com.shanjiancaofu.sort;

import java.util.Arrays;

public class HeapSort_06 {

	public static void main(String[] args) {

		// 首先我们知道二叉树满足的规则 当一个元素的索引为index,
		// 父坐标= （index-1) /2. 左子树的坐标满足 （2*index+1），右子树的坐标满足（2*index+2)
		// 遍历数组， 将最大的值和最后一个节点做交换， 交换完成后再将这个数组进行二叉树构建， 循环这一个过程
		int arr[] = {6, 8, 5, 9, 10, 7, 0, 100};

		// 最后一个元素的数组坐标是  arr.length- 1 , (arr.length-1 -1) /2 = (arr.length-2 )/2 = arr.length/2 -1
		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			// 第一次= 3
			// 第二次 = 2
			// 第三次 = 1
			// 第四次 = 0
			binaryTreeArr(arr, i, arr.length);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			binaryTreeArr(arr, 0, i);
		}
		System.out.println("arr" + Arrays.toString(arr));
	}

	/**
	 * 排序一个大顶部二叉树数组
	 *
	 * @param arr    待调整的数组
	 * @param index  调整这个二叉树的节点的索引
	 * @param length 这个数组被调整的长度
	 */
	public static void binaryTreeArr(int arr[], int index, int length) {
		int nodeValue = arr[index];
		// index 是一个节点的索引， index * 2+ 1 就是左边的叶子节点，  k = k * 2 + 1 其实叶子节点，
		// k = index * 2 + 1, 那么 arr[k+1] = arr[index*2 +2)
		for (int k = index * 2 + 1; k < length; k = k * 2 + 1) {
			// 左边的叶子节点小于右边
			k = (k + 1 < length && arr[k] < arr[k + 1]) ? k + 1 : k;
			if (arr[k] > nodeValue) {
				arr[index] = arr[k];
				index = k;
			} else {
				break;
			}
		}
		arr[index] = nodeValue;
	}
}
