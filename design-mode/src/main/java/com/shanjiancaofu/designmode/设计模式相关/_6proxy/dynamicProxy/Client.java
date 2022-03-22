package com.shanjiancaofu.designmode.设计模式相关._6proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {

		Star realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);

		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[]{Star.class}, handler);

		proxy.sing();

	}

}
