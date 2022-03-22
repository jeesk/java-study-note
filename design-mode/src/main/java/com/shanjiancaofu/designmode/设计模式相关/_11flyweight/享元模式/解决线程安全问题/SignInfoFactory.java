package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式.解决线程安全问题;


import com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式.SignInfo;

import java.util.HashMap;

public class SignInfoFactory {
	//池容器
	private static HashMap<ExtrinsicState, SignInfo> pool = new HashMap<ExtrinsicState, SignInfo>();

	//从池中获得对象
	public static SignInfo getSignInfo(ExtrinsicState key) {
		//设置返回对象
		SignInfo result = null;
		//池中没有该对象，则建立，并放入池中
		if (!pool.containsKey(key)) {
			result = new SignInfo();
			pool.put(key, result);
		} else {
			result = pool.get(key);
		}
		return result;
	}
}
