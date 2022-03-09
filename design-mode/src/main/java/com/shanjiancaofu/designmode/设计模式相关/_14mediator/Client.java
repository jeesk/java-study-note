package com.shanjiancaofu.designmode.设计模式相关._14mediator;

public class Client {
	public static void main(String[] args) {
		Mediator m = new President();

		Market   market = new Market(m);
		Development devp = new Development(m);
		Finacial f = new Finacial(m);

		market.selfAction();
		market.outAction();

		//  中介者模式：
		// 各个部门打交道， 通过总经理来维持。
		//  各个部门持有总经理的对象， 同时在持有总经理 对象的时候， 把总经理将部门注册到自己的容器中。
		// 每个部门在执行外部动作的时候， 会通过总经理去持有的部门对象去调用。
		// 总经理统一的调用各个部门的。

	}
}
