package com.shanjiancaofu.designmode.设计模式相关._1singleton;

/**
 * 六种： 枚举 jdk1.5+
 * 避免多线程同步问题  性能好， 天生线程安全. 不能延迟加载
 */
public enum HungryManEnumMode {
	INSTANCE;

	private HungryManEnumMode() {
	}

}
