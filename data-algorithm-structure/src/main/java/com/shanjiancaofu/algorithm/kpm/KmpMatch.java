package com.shanjiancaofu.algorithm.kpm;

import java.util.Arrays;

//  https://www.cnblogs.com/zzuuoo666/p/9028287.html
public class KmpMatch {


	public static void main(String[] args) {

		// 0000120
		int[] next = kmpNext("ABCDABD");
		System.out.println(Arrays.toString(next));
		int i = kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD", next);
		System.out.println("索引为:" + i);
	}

	public static int kmpSearch(String content, String keyword, int[] next) {
		for (int i = 0, j = 0; i < content.length(); i++) {

			// 这里是查询表让j回退多少次
			while (j > 0 && content.charAt(i) != keyword.charAt(j)) {
				j = next[j - 1];
				// 不相等的时候， 让部分匹配表匹配到相等的索引
			}
			if (content.charAt(i) == keyword.charAt(j)) {
				j++;
			}
			if (j == keyword.length()) {
				return i - j + 1;
			}
		}
		return -1;
	}

	/**
	 * 原模式串子串对应的各个前缀后缀的公共元素的最大长度表为
	 *
	 * @param str 字符串
	 * @return 部分前缀和后缀匹配值表
	 */
	public static int[] kmpNext(String str) {
		int[] next = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < str.length(); i++) {
			// 不相等的时候， 我们需要从next[j-1] 获取新的j
			while (j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}
