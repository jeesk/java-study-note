package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式.解决线程安全问题;

public class Client {
	public static void main(String[] args) {
		//初始化对象池
		ExtrinsicState state1 = new ExtrinsicState();
		state1.setSubject(" 科目 1");
		state1.setLocation(" 上海 ");

		SignInfoFactory.getSignInfo(state1);
		ExtrinsicState state2 = new ExtrinsicState();
		state2.setSubject(" 科目 1");
		state2.setLocation(" 上海 ");


		//计算执行100万次需要的时间
		long currentTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			SignInfoFactory.getSignInfo(state2);
		}
		long tailTime = System.currentTimeMillis();
		System.out.println(" 执行时间： " + (tailTime - currentTime) + " ms");
	}
}

//

class Client1 {
	public static void main(String[] args) {
/*		String key1 = " 科目 1 上海 ";
		String key2 = " 科目 1 上海 ";
		//初始化对象池
		SignInfoFactory.getSignInfo(key1);
		//计算执行10万次需要的时间
		long currentTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			SignInfoFactory.getSignInfo(key2);
		}
		long tailTime = System.currentTimeMillis();
		System.out.println(" 执行时间： " + (tailTime - currentTime) + " ms");*/


	}
}
