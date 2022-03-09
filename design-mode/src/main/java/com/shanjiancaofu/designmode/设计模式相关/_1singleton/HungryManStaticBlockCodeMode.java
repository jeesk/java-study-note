package com.shanjiancaofu.designmode.设计模式相关._1singleton;


//  基于静态 代码块，在实例化或者第一次调用时执行
public class HungryManStaticBlockCodeMode {
	private final static HungryManStaticBlockCodeMode INSTANCE;

	private HungryManStaticBlockCodeMode() {
	}

	static {
		INSTANCE = new HungryManStaticBlockCodeMode();
	}

	public static HungryManStaticBlockCodeMode getInstance() {
		return INSTANCE;
	}
}
