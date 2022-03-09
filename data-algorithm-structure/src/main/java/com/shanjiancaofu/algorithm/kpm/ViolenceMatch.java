package com.shanjiancaofu.algorithm.kpm;


public class ViolenceMatch {
	public static void main(String[] args) {

		int i = voilenMath("中国万岁万岁好", "万岁好");
		System.out.println(i);
	}


	public static int voilenMath(String content, String keyword) {
		char[] contentChar = content.toCharArray();
		char[] keywordChar = keyword.toCharArray();

		int contentLenth = content.length();
		int keywordLenth = keyword.length();
		int contengIndex = 0;
		int keywordIndex = 0;
		// 当遇到相同的字符串 长度各自加一， 不同则查找内容的index 置零，
		// contengIndex = 4, keywordIndex = 2 的时候， 发现下一个字符串不相同， 那么keywordIndex = 0， contentIndex =3
		// 从上次配置的索引以来，keywordIndex 匹配了两个字符串，现在匹配失败了， 那么contengIndex需要从上次索引+1，
		// 中国万岁万岁好 万岁好  , contengIndex = 4, keywordIndex = 2 , 关键字是万岁， 所以第一个关键字万匹配失败， 需要再前进1个索引，从岁开始匹配，
		// 但是岁也匹配不上， 那么索引继续推荐
		while (contengIndex < contentLenth && keywordIndex < keywordLenth) {

			if (contentChar[contengIndex] == keywordChar[keywordIndex]) {
				contengIndex++;
				keywordIndex++;

			} else {
				// conntengIndex 回溯索引
				contengIndex = contengIndex - keywordIndex + 1;
				// j置零
				keywordIndex = 0;

				// 加入这里是kmp 算法的话， 那么 contentIndex = next[contentIndex,]

			}
		}
		if (keywordIndex == keywordLenth) {
			return contengIndex - keywordIndex;
		}
		return -1;
	}

}
