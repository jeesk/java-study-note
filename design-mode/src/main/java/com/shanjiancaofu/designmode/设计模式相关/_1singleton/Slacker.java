package com.shanjiancaofu.designmode.设计模式相关._1singleton;

// 第二种：懒汉式  线程安全， 调用效率不高。 可以延迟初始化. 也可以使用synchronized
public class Slacker {
	private static Slacker INSTANCE;

	private Slacker() {
		if (INSTANCE != null) {
			throw new RuntimeException("不允许调用构造器！");
		}
	}

   /* public static Singleton2 getInstace() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }*/

	public static synchronized Slacker getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Slacker();
		}
		return INSTANCE;
	}
}
