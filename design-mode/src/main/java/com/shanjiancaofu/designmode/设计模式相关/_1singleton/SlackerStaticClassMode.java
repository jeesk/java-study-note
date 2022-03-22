package com.shanjiancaofu.designmode.设计模式相关._1singleton;


/***
 * 静态内部类 4
 *
 * 恶汉模式的优化版，在类被装载时，静态内部类并没有被实例化，
 * 只有getInstance()时才 会装载 Sinleton4Holder 类，静态内部类方式也能很好地，实现线程安全、高效率和延迟加载特性。
 */
public class SlackerStaticClassMode {


	public static SlackerStaticClassMode getInstance() {
		return Sinleton4Holder.INSTANCE;
	}

	private static class Sinleton4Holder {
		private static final SlackerStaticClassMode INSTANCE = new SlackerStaticClassMode();
	}

}
