package com.shanjiancaofu.designmode.设计模式相关._1singleton;

/**
 * 第五种： 双重检查锁机制(锁上类)
 * 懒汉模式的优化版，拥有线程安全、高效率以及延迟加载等特性。但是这种方式需要jdk1.5以上，且在一些平台和编译器下有错。
 * 不建议使用
 */
public class SlackerDoubleCheckMode {
	private static volatile SlackerDoubleCheckMode INSTANCE;

	private SlackerDoubleCheckMode() {
	}


	public static SlackerDoubleCheckMode getInstance() {
		if (INSTANCE == null) {
			synchronized (SlackerDoubleCheckMode.class) {
				if (INSTANCE == null) {
					INSTANCE = new SlackerDoubleCheckMode();
				}
			}
		}
		return INSTANCE;
	}
}
