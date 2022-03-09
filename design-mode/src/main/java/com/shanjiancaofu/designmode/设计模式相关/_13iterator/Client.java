package com.shanjiancaofu.designmode.设计模式相关._13iterator;

public class Client {

	public static void main(String[] args) {
		ConcreteMyAggregate cma = new ConcreteMyAggregate();
		cma.addObject("aa");
		cma.addObject("bb");
		cma.addObject("cc");

		MyIterator iter = cma.createIterator();
		while(iter.hasNext()){
			System.out.println(iter.getCurrentObj());
			iter.next();
		}



		// 内部迭代器 一个类中的内部类可以操作外部的的属性。
		//



	}
}
